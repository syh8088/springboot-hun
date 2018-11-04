package hoon.sevice;

import hoon.dao.member.MemberMapper;
import hoon.dao.member.MemberRepository;
import hoon.model.entity.Member;
import hoon.model.enums.OauthType;
import hoon.util.Constants;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Hibernate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

@Service
@Slf4j
public class MemberService {

    private final MemberMapper memberMapper;
    private final MemberRepository memberRepository;

    private final TransactionTemplate transactionTemplate;

    private static final String IGNORE_FIELD_WHEN_MODIFY[] = {Constants.DELETE_YN, Constants.REGISTER_YMDT, Constants.UPDATE_YMDT};

    @Autowired
    public MemberService(MemberMapper memberMapper, MemberRepository memberRepository, TransactionTemplate transactionTemplate) {
        this.memberMapper = memberMapper;
        this.memberRepository = memberRepository;
        this.transactionTemplate = transactionTemplate;
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
                member = memberMapper.selectByNo(no);
        }
        return member;
    }

    public Member saveSomethingMember(Member member) {
        // NOTE #8  transactionTemplate의 사용
        return transactionTemplate.execute(status -> memberRepository.save(member));
    }

    // NOTE #4-2 JPA 의 Flush 이 되는 시점은 Transaction 이 끝날떄 입니다.
    // NOTE #4-3 findOne, getOne 기타 등등으로 entity 를 가져오면 영속상태가 됩니다.(단, transaction 상태인 경우에만 유지가 됩니다.)
    @Transactional
    public Member modifyNameByName(Member member) {
        Member originMember = memberRepository.findOne(member.getMemberNo());

        // NOTE #4-4 BeanUtils 는 굉장히 유용합니다.
        BeanUtils.copyProperties(member, originMember, IGNORE_FIELD_WHEN_MODIFY);
        // NOTE #4-5 강제 flush = save()
        // memberRepository.save(originMember);
        return member;
    }

    @Transactional
    public Member getMemberByOauthTypeAndId(OauthType type, String id) {
        Member member = memberRepository.findByOauthTypeAndOauthId(type, id);
        if (member != null) {
            Hibernate.initialize(member.getRoles());
        }
        return member;
    }

    public boolean isAlreadyRegisteredId(String id) {
        return memberRepository.findById(id) != null;
    }
}
