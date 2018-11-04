package hoon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/main")
public class LoginController {

    @GetMapping
    public String getMainPage(Principal principal) {

        return "main";
    }

    @GetMapping("/admin")
    public String getAdminPage() {
        return "admin";
    }

    @GetMapping("/writer")
    public String getWriterPage() {
        return "writer";
    }
}
