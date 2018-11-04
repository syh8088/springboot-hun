package hoon.dao.member;

import hoon.model.entity.Member;
import hoon.model.enums.OauthType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MemberRepository extends JpaRepository<Member, Long>, MemberRepositoryCustom {

    Member findByMemberNo(long no);

    @Query(value = "select m from Member m where m.memberNo = :no", nativeQuery = false)
    Member selectByNo(@Param("no") long no);

    Member findByOauthTypeAndOauthId(OauthType oauthType, String oauthId);
}
