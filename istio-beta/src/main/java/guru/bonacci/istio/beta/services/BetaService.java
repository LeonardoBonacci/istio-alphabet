package guru.bonacci.istio.beta.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;

@Slf4j
@Service
public class BetaService {

    public String echo(String foo) {
        String echo = foo + " "  + new Date();
        log.info("The response will be '{}'", echo);
        return echo;
    }
}