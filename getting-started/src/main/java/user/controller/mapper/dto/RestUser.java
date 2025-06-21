package user.controller.mapper.dto;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class RestUser {
    private Long userId;
    private String userName;
    private String email;
}
