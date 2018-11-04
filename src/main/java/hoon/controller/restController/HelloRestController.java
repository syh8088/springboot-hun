package hoon.controller.restController;

import hoon.sevice.HelloService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "Test")
public class HelloRestController {

    private final HelloService helloService;

    @Autowired
    public HelloRestController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/")
    @ApiOperation(value = "Check server health", notes = "If it is normal, it returns 'HelloService'")
    public String hello() {
        return helloService.getService();
    }
}
