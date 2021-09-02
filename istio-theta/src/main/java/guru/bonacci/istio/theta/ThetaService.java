package guru.bonacci.istio.theta;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ThetaService {

    private final DeltaClient deltaClient;

    public String get(String foo) {
        log.info("Request '{}'", foo);
        String response = deltaClient.get(foo);
        log.info("The response will be '{}'", response);
        return response;
    }
}