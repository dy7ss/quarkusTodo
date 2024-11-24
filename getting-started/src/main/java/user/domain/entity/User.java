package user.domain.entity;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class User {
    private Long userId;
    private String userName;
    private String email;
}
