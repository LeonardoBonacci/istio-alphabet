package guru.bonacci.istio.beta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class BetaApp {

	public static void main(String[] args) {
		SpringApplication.run(BetaApp.class, args);
	}


	@Configuration
	public class WebConfiguration extends WebMvcConfigurerAdapter {
		@Override
		public void addInterceptors(InterceptorRegistry registry) {
			registry.addInterceptor(new LogHeadersInterceptor());
		}
	}
}
