package hoon.dao.member;

import hoon.model.entity.Member;
import hoon.model.entity.QMember;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

public class MemberRepositoryImpl extends QueryDslRepositorySupport implements MemberRepositoryCustom {

    QMember member = QMember.member;

    /**
     * Creates a new {@link QueryDslRepositorySupport} instance for the given domain type.
     *
     * @param domainClass must not be {@literal null}.
     */
    public MemberRepositoryImpl() {
        super(Member.class);
    }

    @Override
    public Member getMemberByNo(long no) {

        return from(member)
                .where(member.memberNo.eq(no))
                .fetchOne();
    }
}
