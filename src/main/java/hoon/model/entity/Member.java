package hoon.model.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

@Getter
@Setter
@ToString
@Alias("Member") // TODO #13
public class Member {
    // TODO #4 Member entity
    private Long memberNo;
    private String id;
    private String password;
    private String name;
}
