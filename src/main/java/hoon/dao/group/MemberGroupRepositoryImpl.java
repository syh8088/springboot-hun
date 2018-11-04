package hoon.dao.group;

import com.querydsl.core.types.Projections;
import hoon.model.entity.MemberGroup;
import hoon.model.entity.QMember;
import hoon.model.entity.QMemberGroup;
import hoon.model.view.MemberGroupViewModel;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

public class MemberGroupRepositoryImpl extends QueryDslRepositorySupport implements MemberGroupRepositoryCustom {

    QMemberGroup memberGroup = QMemberGroup.memberGroup;
    QMember member = QMember.member;

    public MemberGroupRepositoryImpl() {
        super(MemberGroup.class);
    }

    @Override
    public MemberGroup selectByNo(long no) {
        // TODO #4-12 아래와 같이 QueryDSL 의 fetchJoin 으로 N+1 문제를 해결합니다.
        return from(memberGroup)
                .leftJoin(memberGroup.members, member).fetchJoin()
                .leftJoin(member.roles).fetchJoin()
                .where(memberGroup.memberGroupNo.eq(no))
                .fetchOne();
    }

    @Override
    public MemberGroupViewModel selectMemberGroupViewModel(long no) {
        // TODO #4-13 Projections.bean 과 select()를 사용하면 entity 가 아닌 모델도 리턴할 수 있습니다.
        return from(memberGroup)
                .select(
                        Projections.bean(MemberGroupViewModel.class,
                                memberGroup.memberGroupNo,
                                memberGroup.name.as("customMsg")))
                .where(memberGroup.memberGroupNo.eq(no))
                .fetchOne();
    }
}
