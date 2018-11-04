package hoon.sevice;

import hoon.dao.group.MemberGroupRepository;
import hoon.dao.member.MemberMapper;
import hoon.dao.member.MemberRepository;
import hoon.model.entity.Member;
import hoon.util.Constants;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberService {

    private final MemberMapper memberMapper;
    private final MemberRepository memberRepository;

    private static final String IGNORE_FIELD_WHEN_MODIFY[] = {Constants.DELETE_YN, Constants.REGISTER_YMDT, Constants.UPDATE_YMDT};

    @Autowired
    MemberGroupRepository memberGroupRepository;

    @Autowired
    public MemberService(MemberMapper memberMapper, MemberRepository memberRepository) {
        this.memberMapper = memberMapper;
        this.memberRepository = memberRepository;
    }

    public Member getMember(long no, String type) {

        Member member;
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
                member = memberMapper.selectById(no);
        }
        return member;
    }

    public Member saveSomethingMember(Member member) {
        return memberRepository.save(member);
    }

    // TODO #4-2 JPA 의 Flush 이 되는 시점은 Transaction 이 끝날떄 입니다.
    // TODO #4-3 findOne, getOne 기타 등등으로 entity 를 가져오면 영속상태가 됩니다.(단, transaction 상태인 경우에만 유지가 됩니다.)
    @Transactional
    public Member modifyNameByName(Member member) {
        Member originMember = memberRepository.findOne(member.getMemberNo());

        // TODO #4-4 BeanUtils 는 굉장히 유용합니다.
        BeanUtils.copyProperties(member, originMember, IGNORE_FIELD_WHEN_MODIFY);
        // TODO #4-5 강제 flush = save()
        // memberRepository.save(originMember);
        return member;
    }
}
