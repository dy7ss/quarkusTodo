package user.controller.mapper;

import java.util.List;

import user.controller.dto.RestUser;
import user.domain.entity.User;

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
                .email(user.getEmail())
                .build();
    }
}
