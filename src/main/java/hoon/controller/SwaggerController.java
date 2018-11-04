package hoon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SwaggerController {

    @RequestMapping("/swagger")
    public String getSwagger() {
        return "redirect:/swagger-ui.html";
    }
}
