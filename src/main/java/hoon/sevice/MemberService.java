package hoon.sevice;

import hoon.dao.member.MemberMapper;
import hoon.dao.member.MemberRepository;
import hoon.model.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

@Service
public class MemberService {

    private final MemberMapper memberMapper;

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberMapper memberMapper, MemberRepository memberRepository) {
        this.memberMapper = memberMapper;
        this.memberRepository = memberRepository;
    }

    public Member getMember(long no, String type) {

        Member member = null;
        switch (type) {
            case "default":
                member = memberRepository.findOne(no);
                break;
            case "query":
                member = memberRepository.findByMemberNo(no);
                break;
            case "JPQL":
                member = memberRepository.selectByNo(no);
                break;
            case "queryDSL":
                member = memberRepository.getMemberByNo(no);
                break;
            default:
                memberMapper.selectById(no);
        }

        return member;
    }

    public Member saveSomethingMember() {
        Member member = new Member();
        member.setId("do" + new Random().nextInt());
        member.setPassword("1234");
        return memberRepository.save(member);
    }

    @Transactional
    public Member modifyNameByName(long no) {
        Member member = memberRepository.findOne(no);
        member.setName(member.getName() + new Random().nextInt());
        memberRepository.save(member);
        return member;
    }
}
