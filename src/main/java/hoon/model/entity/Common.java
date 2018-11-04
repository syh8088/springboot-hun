package hoon.model.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@Setter
// NOTE #4-4 공통적인 entity 의 column 은 @MappedSuperclass 이용해 정의할 수 있습니다.
@MappedSuperclass

// NOTE #4-5 @CreatedDate, LastModifyedDate를 사용하려면 아래의 리스너를 등록해야합니다.
@EntityListeners(AuditingEntityListener.class)

abstract class Common {

    // NOTE #4-7 @Type 을 사용하면 boolean <-> "Y" , "N" 컨버팅이 알아서 됩ㄴ니다.
    @Type(type = "yes_no")
    private Boolean deleteYn = false;

    @CreatedDate
    private LocalDateTime registerYmdt;

    @LastModifiedDate
    private LocalDateTime updateYmdt;
}
