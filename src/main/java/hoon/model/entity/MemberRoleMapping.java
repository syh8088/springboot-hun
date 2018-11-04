package hoon.model.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@ToString
public class MemberRoleMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int memberRoleMappingNo;

    @Column(nullable = false)
    private int memberNo;

    @Column(nullable = false)
    private int roleNo;
}