package guru.bonacci.istio.alpha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class AlphaApp {

	public static void main(String[] args) {
		SpringApplication.run(AlphaApp.class, args);
	}

}
