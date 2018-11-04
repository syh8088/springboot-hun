package hoon.dao.member;

import hoon.model.entity.Member;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface MemberMapper {

    Member selectById(long no);
}
