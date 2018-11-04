package hoon.dao.member;

import hoon.model.entity.Member;

public interface MemberRepositoryCustom {

    Member getMemberByNo(long no);
}
