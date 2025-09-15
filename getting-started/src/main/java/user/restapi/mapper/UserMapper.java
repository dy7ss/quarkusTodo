package user.restapi.mapper;

import java.util.List;

import user.domain.entity.User;
import user.restapi.dto.RestUser;

public class UserMapper {
    public static List<RestUser> toUsers(List<User> users){
        return users.stream()
                .map(UserMapper::toUser)
                .toList();
    }
    public static RestUser toUser(User user) {
        return RestUser.builder()
                .userId(user.getUserId())
                .userName(user.getUserName())
                .email(user.getEmail().getStringValue())
                .build();
    }
}
