package user.controller.mapper;

import java.util.List;

import user.controller.mapper.dto.RestUser;
import user.domain.entity.User;

public class UserMapper {
    public static List<RestUser> toUsers(List<User> users){
        return users.stream()
                .map(user -> RestUser.builder()
                        .userId(user.getUserId())
                        .userName(user.getUserName())
                        .email(user.getEmail())
                        .build())
                .toList();
    }
}
