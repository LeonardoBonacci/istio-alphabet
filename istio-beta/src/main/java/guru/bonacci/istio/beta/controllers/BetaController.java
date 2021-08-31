package guru.bonacci.istio.beta.controllers;

import guru.bonacci.istio.beta.services.BetaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class BetaController {

	private final BetaService service;

	@GetMapping("/")
	@ResponseBody
	public String apiTestUrl() {
		return "Hi at " + new Date();
	}

	@GetMapping("/beta/{foo}")
	@ResponseBody
	public String beta(@PathVariable("foo") String foo) {
		return service.echo(foo);
	}
}
