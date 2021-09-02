package guru.bonacci.istio.delta;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Slf4j
@Service
@RequiredArgsConstructor
public class DeltaService {

    private final Map<String, Long> foos = new HashMap<>();

    @KafkaListener(topics = {"bar-odd", "bar-even"})
    public void listenFoo(Integer fooLength,
          @Header(KafkaHeaders.RECEIVED_TIMESTAMP) long ts) {
        log.info("Received Message: {} at {}", fooLength, ts);
        foos.put(fooLength.toString(), ts);
    }

    public String when(String foo) {
        log.info("When again? {}", foo);
        String result = "not found";
        if (foos.containsKey(foo))
            result = "At " + foos.get(foo);

        return result;
    }
}