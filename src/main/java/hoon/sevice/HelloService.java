package hoon.sevice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

    @Value("${healthCheckMessage}")
    private String healthCheckMessage;

    public String getService() {
        return healthCheckMessage;
    }
}
