package guru.bonacci.istio.theta;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(url="${delta-service-url}", name="delta-service")
public interface DeltaClient {

    @RequestMapping(method=RequestMethod.GET, value="/delta/{foo}", produces = "application/json")
    public String get(@PathVariable("foo") String foo);
}