package hoon.controller.restController;

import hoon.model.entity.Member;
import hoon.sevice.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/{no}")
    public ResponseEntity<Member> getMember(@PathVariable("no") long no) {
        return ResponseEntity.ok().body(memberService.getMember(no));
    }
}