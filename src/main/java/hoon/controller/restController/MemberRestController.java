package hoon.controller.restController;

import hoon.model.entity.Member;
import hoon.model.request.MemberRequest;
import hoon.sevice.MemberService;
import hoon.util.Constants;
import hoon.util.validator.Validator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("members")
@Api(tags = "Member")
public class MemberRestController {

    private final MemberService memberService;

    private final Validator validator;

    @Autowired
    public MemberRestController(MemberService memberService, Validator validator) {
        this.memberService = memberService;
        this.validator = validator;
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
    public ResponseEntity<?> saveMember(@RequestBody @ApiParam(value = "Member") @Valid MemberRequest memberRequest, BindingResult bindingResult, Model model) {

        // NOTE #10 단순 검증
        if (bindingResult.hasErrors()) {
            return ResponseEntity.ok(bindingResult.getAllErrors());
        }

        // NOTE #10 데이터 유효성 검증
        validator.member(memberRequest);

        Member member = new Member();
        BeanUtils.copyProperties(memberRequest, member);

        return ResponseEntity.ok().body(memberService.saveSomethingMember(member));
    }

    @PutMapping
    @ApiOperation(value = "Update member", notes = "Updates a member and returns the entity.")
    public ResponseEntity<Member> modifyMember(@RequestBody @ApiParam(value = "Member") Member member) {
        // TODO MemberResponse 와 같은 객체를 만들어서 수정 가능한 멤버 속성을 제한해야 합니다.
        return ResponseEntity.ok().body(memberService.modifyNameByName(member));
    }
}