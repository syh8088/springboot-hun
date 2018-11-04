package hoon.model.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Member {
    private Long memberNo;
    private String id;
    private String password;
    private String name;
}
