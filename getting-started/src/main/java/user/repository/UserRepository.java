package user.repository;

import java.util.List;
import java.util.Optional;

import jakarta.enterprise.context.ApplicationScoped;
import user.domain.UserRepositoryImple;
import user.domain.entity.User;
import user.repository.entity.UserEntity;
import user.repository.mapper.UserMapper;

@ApplicationScoped
public class UserRepository implements UserRepositoryImple{

    @Override
    public Optional<User> getById(Long id) {
        UserEntity result = UserEntity.findById(id);
        if (result == null) {
            return Optional.empty();
        }
        return Optional.of(UserMapper.toUser(result));
    }

    @Override
    public List<User> list() {
        List<UserEntity> response = UserEntity.listAll();
        return UserMapper.toUsers(response);
    }
}
