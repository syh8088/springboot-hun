package hoon.controller;

import hoon.error.errorCode.MemberErrorCode;
import hoon.error.exception.MemberException;
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

    @GetMapping("/error")
    public String memberError() {

        if (1 == 1)
            throw new MemberException(MemberErrorCode.NOT_FOUND_MEMBER);
        return "writer";
    }
}
