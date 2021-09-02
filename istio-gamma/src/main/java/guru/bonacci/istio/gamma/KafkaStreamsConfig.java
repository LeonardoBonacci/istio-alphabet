package guru.bonacci.istio.gamma;

import brave.kafka.streams.KafkaStreamsTracing;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.EnableKafkaStreams;
import org.springframework.kafka.annotation.KafkaStreamsDefaultConfiguration;
import org.springframework.kafka.config.KafkaStreamsConfiguration;
import org.springframework.kafka.support.KafkaStreamBrancher;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@EnableKafka
@Configuration
@EnableKafkaStreams
@RequiredArgsConstructor
public class KafkaStreamsConfig {

    @Value( "${spring.application.name}" ) String appName;
    @Value( "${kafka.broker}" ) String broker;

    private final KafkaStreamsTracing kafkaStreamsTracing;

    @Bean(name = KafkaStreamsDefaultConfiguration.DEFAULT_STREAMS_CONFIG_BEAN_NAME)
    public KafkaStreamsConfiguration kStreamsConfigs() {
        Map<String, Object> props = new HashMap<>();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, appName);
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, broker);
        props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
        props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
        return new KafkaStreamsConfiguration(props);
    }

    @Bean
    public KStream<String, Integer> kStream(StreamsBuilder builder) {
        KStream<String, String> fooStream = builder.stream("foo", Consumed.with(Serdes.String(), Serdes.String()));
        KStream<String, Integer> barStream = fooStream
                .transformValues(kafkaStreamsTracing.peek("receiving", (k, v) -> {
                    log.info("incoming {}", v);
                }))
                .mapValues((ValueMapper<String, Integer>) String::length);

        return new KafkaStreamBrancher<String, Integer>()
                .branch((k, v) -> v % 2 == 0, evenStream -> evenStream
                        .transformValues(kafkaStreamsTracing.peek("even", (k, v) -> {
                            log.info("Even: {}", String.valueOf(v));
                        }))
                        .to("bar-even", Produced.with(Serdes.String(), Serdes.Integer())))
                .defaultBranch(oddStream -> oddStream
                        .transformValues(kafkaStreamsTracing.peek("odd", (k, v) -> {
                            log.info("Odd: {}", String.valueOf(v));
                        }))
                        .to("bar-odd", Produced.with(Serdes.String(), Serdes.Integer())))
                .onTopOf(barStream);
    }
}
