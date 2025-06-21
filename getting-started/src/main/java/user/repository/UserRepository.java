package user.repository;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import user.domain.UserRepositoryImple;
import user.domain.entity.User;
import user.repository.entity.UserEntity;
import user.repository.mapper.UserMapper;

@ApplicationScoped
public class UserRepository implements UserRepositoryImple{

    @Override
    public String getById() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public List<User> list() {
        List<UserEntity> response = UserEntity.listAll();
        return UserMapper.toUsers(response);
    }
}
