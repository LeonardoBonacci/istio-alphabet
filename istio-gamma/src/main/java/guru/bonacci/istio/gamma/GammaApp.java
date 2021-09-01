package guru.bonacci.istio.gamma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafkaStreams;

@SpringBootApplication
public class GammaApp {

	public static void main(String[] args) {
		SpringApplication.run(GammaApp.class, args);
	}
}
