package user.repository.mapper;

import java.util.List;

import user.domain.entity.Email;
import user.domain.entity.User;
import user.repository.entity.UserEntity;

public class UserMapper {

    public static List<User> toUsers(List<UserEntity> response) {
        return response.stream().map(i -> toUser(i)).toList();
    }
    
    public static User toUser(UserEntity userEntity){
        return User.builder()
        .userId(userEntity.getUserId())
        .userName(userEntity.getUserName())
        .email(new Email(userEntity.getEmail()))
        .build();
    }

    public static UserEntity toUserEntity(User user) {
        return UserEntity.builder()
                .userId(user.getUserId())
                .userName(user.getUserName())
                .email(user.getEmail().getStringValue())
                .build();
    }
    
    
}
