package guru.bonacci.istio.alpha;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@Slf4j
@EnableFeignClients
@SpringBootApplication
public class AlphaApp {

	public static void main(String[] args) {
		SpringApplication.run(AlphaApp.class, args);
	}
}
