package hoon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
// NOTE #4-6 audition 을 사용하려면 아래의 어노테이션도 필요해요
@EnableJpaAuditing
public class Application {
    public static void main(String args[]) {
        SpringApplication.run(Application.class);
    }
}

