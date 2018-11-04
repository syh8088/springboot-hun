package hoon.dao.member;

import hoon.model.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

//TODO #3-1 JPA
public interface MemberRepository extends JpaRepository<Member, Long>, MemberRepositoryCustom {

    // TODO #3-2 Query Method
    Member findByMemberNo(long no);

    // TODO #3-3 JQPL, SQL
    @Query(value = "select m from Member m where m.memberNo = :no", nativeQuery = false)
    Member selectByNo(@Param("no") long no);
}
