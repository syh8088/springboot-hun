package hoon.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import hoon.annotation.Encrypt;
import hoon.model.enums.EncryptType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
public class Member extends Common {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long memberNo;
    private String id;

    @Encrypt
    private String password;
    private String name;

    // NOTE #4-8 ManyToOne
    @ManyToOne
    @JoinColumn(name = "member_group_no")
    @JsonIgnore
    private MemberGroup memberGroup;

    // NOTE #4-10 ManyToMany
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "member_role_mapping",
            joinColumns = @JoinColumn(name = "memberNo"),
            inverseJoinColumns = @JoinColumn(name = "roleNo"))
    private List<Role> roles = new ArrayList<>();


    // NOTE #4-11
    /*
     * fetchType 이 Eager 인 경우 findOne 할때 함꼐 join
     * Lazy 인 경우엔 해당 entity의 멤버 변수에 get 할떄 join
     *
     * 1:N 구조의 경우 (member & role) Eager든 Lazy든 문제가 생긴다.
     * (Lazy의 경우엔 해당 collection 을 순회할 때만, 그렇지만 보통 다 순회하니까 문제 생김)
     *
     * 이땐 fetchJon을 사용한다. -> JPQL FetchJoin 참고
     */
}
