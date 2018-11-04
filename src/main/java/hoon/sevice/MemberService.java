package hoon.sevice;

import hoon.dao.MemberMapper;
import hoon.model.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    private final MemberMapper memberMapper;

    @Autowired
    public MemberService(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    public Member getMember(long no) {
        return memberMapper.selectById(no);
    }
}
