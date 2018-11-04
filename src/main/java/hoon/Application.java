package hoon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

@SpringBootApplication
// NOTE #4-6 audition 을 사용하려면 아래의 어노테이션도 필요해요
@EnableJpaAuditing
@EnableAspectJAutoProxy
@EnableOAuth2Client
@EnableCaching
public class Application {
    public static void main(String args[]) {
        SpringApplication.run(Application.class);
    }
}

