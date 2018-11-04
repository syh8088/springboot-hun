package hoon.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class LogUtil {

    @Async
    public void loggingByAsync() {
        log.info("loggingByAsync ing");
    }
}
