package hoon.controller.restController;

import hoon.model.entity.MemberGroup;
import hoon.model.view.MemberGroupViewModel;
import hoon.sevice.MemberGroupService;
import hoon.util.Constants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("memberGroups")
@Api(tags = "MemberGroup")
public class MemberGroupRestController {

    private final MemberGroupService memberGroupService;

    @Autowired
    public MemberGroupRestController(MemberGroupService memberGroupService) {
        this.memberGroupService = memberGroupService;
    }

    @GetMapping("{no}")
    @ApiOperation(value = "Get group", notes = "Returns the group and each member.")
    public ResponseEntity<MemberGroup> getMemberGroup(@PathVariable("no") @ApiParam(value = "Group no", defaultValue = "1") long no) {
        return ResponseEntity.ok().body(memberGroupService.getMemberGroup(no, Constants.EMPTY));
    }

    @GetMapping("{no}/types/{type}")
    @ApiOperation(value = "Get group into type", notes = "Returns the group and each member of the type.")
    public ResponseEntity<MemberGroup> getMemberGroup(@PathVariable("no") @ApiParam(value = "Group no", defaultValue = "1") long no,
                                                      @PathVariable("type") @ApiParam(value = "Fetching type", defaultValue = "queryDSL") String type) {
        return ResponseEntity.ok().body(memberGroupService.getMemberGroup(no, type));
    }

    @GetMapping("{no}/MemberGroupViewModel")
    @ApiOperation(value = "Get group(front-only)", notes = "Returns front-only group model.")
    public ResponseEntity<MemberGroupViewModel> getMemberGroupViewModel(@PathVariable("no") @ApiParam(value = "Group no", defaultValue = "1") long no) {
        return ResponseEntity.ok().body(memberGroupService.getMemberGroupViewModel(no));
    }
}
