package hoon.config.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

// NOTE #10 MemberException은 bean이 아닌데 MessageSouce를 필요로 한다! 이럴 떄 아래와 같은 패턴으로 autowired 없이 public static String getMessage(String code)을 제공한다.
@Component
public class CustomMessageHandler {

    // 스프링 꺼
    // private final MessageSource messageSource;

    // 내 꺼(static!)
    private static MessageSource staticMessageSource;

    @Autowired
    public CustomMessageHandler(MessageSource messageSource) {
        staticMessageSource = messageSource;
    }

//    @PostConstruct
//    public void newInstance() {
//        staticMessageSource = staticMessageSource;
//    }

    public static String getMessage(String code) {
        return staticMessageSource.getMessage(code, null, LocaleContextHolder.getLocale());
    }
}