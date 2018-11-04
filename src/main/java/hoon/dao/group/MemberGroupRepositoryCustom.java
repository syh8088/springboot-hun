package hoon.dao.group;

import hoon.model.entity.MemberGroup;
import hoon.model.view.MemberGroupViewModel;

public interface MemberGroupRepositoryCustom {

    MemberGroup selectByNo(long no);

    MemberGroupViewModel selectMemberGroupViewModel(long no);
}
