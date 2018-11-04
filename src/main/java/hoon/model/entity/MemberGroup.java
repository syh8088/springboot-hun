package hoon.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Getter
@Setter
@Entity
public class MemberGroup extends Common {

    @Id
    private long memberGroupNo;
    private String name;
    private String description;

    // TODO #4-9 OneToMany
    @OneToMany(mappedBy = "memberGroup", fetch = FetchType.LAZY)
    Set<Member> members = new HashSet<>();
}
