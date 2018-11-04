package hoon.model.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@Entity // TODO #1 JPA @Entity
public class Member {

    // TODO #2 @Id는 필수!
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long memberNo;
    private String id;
    private String password;
    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "member_role_mapping",
            joinColumns = @JoinColumn(name = "memberNo"),
            inverseJoinColumns = @JoinColumn(name = "roleNo"))
    private List<Role> roles = new ArrayList<>();
}
