package hoon.controller.restController;

import hoon.model.entity.Member;
import hoon.sevice.MemberService;
import hoon.util.Constants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("members")
@Api(tags = "Member")
public class MemberRestController {

    private final MemberService memberService;

    @Autowired
    public MemberRestController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("{no}")
    @ApiOperation(value = "Get members by no ", notes = "Returns the member.")
    public ResponseEntity<Member> getMember(@PathVariable("no") @ApiParam(value = "Member no", defaultValue = "1") long no) {
        return ResponseEntity.ok().body(memberService.getMember(no, Constants.EMPTY));
    }

    @GetMapping("{no}/types/{type}")
    @ApiOperation(value = "Get member into type", notes = "Returns the member of the type")
    public ResponseEntity<Member> getMember(@PathVariable("no") @ApiParam(value = "Member no", defaultValue = "1") long no,
                                            @PathVariable(value = "type", required = false) @ApiParam(value = "Fetching type", defaultValue = "queryDSL") String type) {
        return ResponseEntity.ok().body(memberService.getMember(no, type));
    }

    // NOTE #4-1  REST API 규칙을 꼭 지키자!
    @PostMapping
    @ApiOperation(value = "Create member", notes = "Creates a member and returns the entity.")
    public ResponseEntity<Member> saveMember(@RequestBody @ApiParam(value = "Member") Member member) {
        return ResponseEntity.ok().body(memberService.saveSomethingMember(member));
    }

    @PutMapping
    @ApiOperation(value = "Update member", notes = "Updates a member and returns the entity.")
    public ResponseEntity<Member> modifyMember(@RequestBody @ApiParam(value = "Member") Member member) {
        return ResponseEntity.ok().body(memberService.modifyNameByName(member));
    }
}