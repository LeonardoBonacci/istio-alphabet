package guru.bonacci.istio.alpha;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.kafka.annotation.KafkaListener;

@Slf4j
@EnableFeignClients
@SpringBootApplication
public class AlphaApp {

	public static void main(String[] args) {
		SpringApplication.run(AlphaApp.class, args);
	}

	@KafkaListener(topics = "foo")
	public void listenGroupFoo(String message) {
		log.info("Received Message: " + message);
	}
}
