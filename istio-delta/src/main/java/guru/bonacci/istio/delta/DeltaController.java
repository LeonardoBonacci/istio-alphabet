package guru.bonacci.istio.delta;

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
public class DeltaController {

	private final DeltaService service;

	@GetMapping("/")
	@ResponseBody
	public String apiTestUrl() {
		return "Hi at " + new Date();
	}

	@GetMapping("/delta/{foo}")
	@ResponseBody
	public String alpha(@PathVariable("foo") String foo) {
		return service.when(foo);
	}
}
