package guru.bonacci.istio.alpha;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AlphaService {

    private final BetaClient betaClient;

    public String get(String foo) {
        String response = betaClient.get(foo);
        log.info("The response will be '{}'", response);
        return response;
    }
}