package hoon.controller.restController;

import hoon.model.entity.Member;
import hoon.sevice.MemberService;
import hoon.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("members")
public class MemberRestController {

    private final MemberService memberService;

    @Autowired
    public MemberRestController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("{no}")
    public ResponseEntity<Member> getMember(@PathVariable("no") long no) {
        return ResponseEntity.ok().body(memberService.getMember(no, Constants.EMPTY));
    }

    @GetMapping("{no}/types/{type}")
    public ResponseEntity<Member> getMember(@PathVariable("no") long no, @PathVariable(value = "type", required = false) String type) {
        return ResponseEntity.ok().body(memberService.getMember(no, type));
    }

    // TODO #4-1  REST API 규칙을 꼭 지키자!
    @PostMapping
    public ResponseEntity<Member> saveMember(@RequestBody Member member) {
        return ResponseEntity.ok().body(memberService.saveSomethingMember(member));
    }

    @PutMapping
    public ResponseEntity<Member> modifyMember(@RequestBody Member member) {
        return ResponseEntity.ok().body(memberService.modifyNameByName(member));
    }
}