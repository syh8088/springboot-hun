package hoon.dao.group;

import hoon.model.entity.MemberGroup;
import hoon.model.entity.QMemberGroup;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

public class MemberGroupRepositoryImpl extends QueryDslRepositorySupport implements MemberGroupRepositoryCustom {

    QMemberGroup memberGroup = QMemberGroup.memberGroup;

    public MemberGroupRepositoryImpl() {
        super(MemberGroup.class);
    }

    @Override
    public MemberGroup selectByNo(long no) {

        return from(memberGroup)
                .leftJoin(memberGroup.members).fetchJoin()
                .where(memberGroup.memberGroupNo.eq(no))
                .fetchOne();
    }
}
