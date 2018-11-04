package hoon.sevice;

import hoon.dao.group.MemberGroupRepository;
import hoon.model.entity.MemberGroup;
import hoon.model.view.MemberGroupViewModel;
import hoon.util.CustomTransactionManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class MemberGroupService {

    private final MemberGroupRepository memberGroupRepository;

    private final CustomTransactionManager transactionManager;

    @Autowired
    public MemberGroupService(MemberGroupRepository memberGroupRepository, CustomTransactionManager transactionManager) {
        this.memberGroupRepository = memberGroupRepository;
        this.transactionManager = transactionManager;
    }

    public MemberGroup getMemberGroup(long no, String type) {
        MemberGroup memberGroup = null;
        try {
            transactionManager.start();
            switch (type) {
                case "queryDSL":
                    memberGroup = memberGroupRepository.selectByNo(no);
                    break;
                default:
                    memberGroup = memberGroupRepository.findOne(no);
            }

            // NOTE #4-14 이곳에서 lazy와 eager의 차이를 확인해 보세요.
            memberGroup.getMembers().forEach(member -> log.info("something"));
            transactionManager.commit();
        } catch (Exception e) {
            transactionManager.rollback();
        }

        return memberGroup;
    }

    public MemberGroupViewModel getMemberGroupViewModel(long no) {
        return memberGroupRepository.selectMemberGroupViewModel(no);
    }
}
