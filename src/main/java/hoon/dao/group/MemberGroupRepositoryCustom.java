package hoon.dao.group;

import hoon.model.entity.MemberGroup;

public interface MemberGroupRepositoryCustom {

    MemberGroup selectByNo(long no);
}
