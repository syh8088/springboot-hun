package hoon.util.validator;

import hoon.error.errorCode.MemberErrorCode;
import hoon.error.exception.MemberException;
import hoon.model.request.MemberRequest;
import hoon.sevice.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Validator {

    @Autowired
    private MemberService memberService;

    public void member(MemberRequest memberRequest) {

        if (memberRequest.getPassword().length() < 10) {
            throw new MemberException(MemberErrorCode.NOT_VALID_PASSWORD_LENGTH);
        }

        if (memberService.isAlreadyRegisteredId(memberRequest.getId())) {
            throw new MemberException(MemberErrorCode.ALREADY_JOIN_ID);
        }
    }
}
