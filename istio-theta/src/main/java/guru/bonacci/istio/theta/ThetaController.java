package guru.bonacci.istio.theta;

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
public class ThetaController {

	private final ThetaService service;

	@GetMapping("/")
	@ResponseBody
	public String apiTestUrl() {
		return "Hi at " + new Date();
	}

	@GetMapping("/theta/{foo}")
	@ResponseBody
	public String alpha(@PathVariable("foo") String foo) {
		return service.get(foo);
	}
}
