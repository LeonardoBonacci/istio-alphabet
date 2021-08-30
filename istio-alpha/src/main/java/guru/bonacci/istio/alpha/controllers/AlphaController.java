package guru.bonacci.istio.alpha.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
@RequestMapping("/")
public class AlphaController {

	@GetMapping("/")
	@ResponseBody
	public String apiTestUrl()
	{
		return "Hi at " + new Date();
	}
}
