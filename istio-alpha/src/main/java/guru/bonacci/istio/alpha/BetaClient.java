package guru.bonacci.istio.alpha;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(url="${beta-service-url}", name="beta-service")
public interface BetaClient  {

    @RequestMapping(method=RequestMethod.GET, value="/beta/{foo}", produces = "application/json")
    public String get(@PathVariable("foo") String foo);
}