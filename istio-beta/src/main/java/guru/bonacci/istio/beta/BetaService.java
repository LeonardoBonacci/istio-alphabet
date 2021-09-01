package guru.bonacci.istio.beta;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.Date;

@Slf4j
@Service
@RequiredArgsConstructor
public class BetaService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public String echo(String foo) {
        sendMessage(foo);
        String echo = foo + " "  + new Date();
        log.info("The response will be '{}'", echo);
        return echo;
    }

    private void sendMessage(String message) {
        ListenableFuture<SendResult<String, String>> future =
                kafkaTemplate.send("foo", message);

        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {

            @Override
            public void onSuccess(SendResult<String, String> result) {
               log.info("Sent Kafka message=[" + message +
                        "] with offset=[" + result.getRecordMetadata().offset() + "]");
            }
            @Override
            public void onFailure(Throwable ex) {
                log.info("Unable to send message=["
                        + message + "] due to : " + ex.getMessage());
            }
        });
    }
}