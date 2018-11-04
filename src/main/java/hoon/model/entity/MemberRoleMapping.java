package hoon.model.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity // TODO #7 JPA Entity
public class MemberRoleMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int memberRoleMappingNo;

    @Column(nullable = false)
    private int memberNo;

    @Column(nullable = false)
    private int roleNo;
}