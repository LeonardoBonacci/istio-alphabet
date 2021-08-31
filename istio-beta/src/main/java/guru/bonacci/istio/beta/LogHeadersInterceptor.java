package guru.bonacci.istio.beta;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

@Slf4j
@RequiredArgsConstructor
public class LogHeadersInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler) {

        log.info("intercepting..");

        try
        {
            Enumeration<String> e = request.getHeaderNames();
            while (e.hasMoreElements())
            {
                String header = e.nextElement();
                if (header.startsWith("x-"))
                {
                    String value = request.getHeader(header);
                    log.info("received '{}:{}'", header, value);
                }
            }
        }
        catch (IllegalStateException e) {}

        return true;
    }
}