package hoon.controller.restController;

import hoon.model.entity.MemberGroup;
import hoon.model.view.MemberGroupViewModel;
import hoon.sevice.MemberGroupService;
import hoon.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("memberGroups")
public class MemberGroupRestController {

    private final MemberGroupService memberGroupService;

    @Autowired
    public MemberGroupRestController(MemberGroupService memberGroupService) {
        this.memberGroupService = memberGroupService;
    }

    @GetMapping("{no}")
    public ResponseEntity<MemberGroup> getMemberGroup(@PathVariable("no") long no) {
        return ResponseEntity.ok().body(memberGroupService.getMemberGroup(no, Constants.EMPTY));
    }

    @GetMapping("{no}/types/{type}")
    public ResponseEntity<MemberGroup> getMemberGroup(@PathVariable("no") long no, @PathVariable("type") String type) {
        return ResponseEntity.ok().body(memberGroupService.getMemberGroup(no, type));
    }

    @GetMapping("/{no}/MemberGroupViewModel")
    public ResponseEntity<MemberGroupViewModel> getMemberGroupViewModel(@PathVariable("no") long no) {
        return ResponseEntity.ok().body(memberGroupService.getMemberGroupViewModel(no));
    }
}
