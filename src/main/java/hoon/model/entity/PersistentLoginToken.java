package hoon.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Getter
@Setter
public class PersistentLoginToken {

    @Id
    @Column
    private String series;

    private String id;

    private String token;

    private Date lastused;
}
