package user.domain.entity;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class User {
    private Long userId;
    @NotEmpty
    private String userName;
    @Valid
    private Email email;
}
