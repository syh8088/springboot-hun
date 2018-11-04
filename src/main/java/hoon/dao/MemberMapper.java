package hoon.dao;

import hoon.model.entity.Member;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

// TODO #10 @Mapper 와 @Repository
@Mapper
@Repository
public interface MemberMapper {

    Member selectById(long no);
}
