package hoon.model.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class MemberRequest {
    @NotNull
    private String id;
    @NotNull
    private String password;
    private String name;
}
