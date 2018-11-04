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

    @GetMapping("/members/{no}/types/{type}")
    public ResponseEntity<Member> getMember(@PathVariable("no") long no, @PathVariable(value = "type", required = false) String type) {
        return ResponseEntity.ok().body(memberService.getMember(no, type));
    }

    @GetMapping("/members") // NOTE: POST
    public ResponseEntity<Member> saveMember() {
        return ResponseEntity.ok().body(memberService.saveSomethingMember());
    }

    @GetMapping("/members/{no}/modify") // NOTE: PUT
    public ResponseEntity<Member> modifyMember(@PathVariable("no") long no) {
        return ResponseEntity.ok().body(memberService.modifyNameByName(no));
    }
}