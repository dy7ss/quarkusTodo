package service;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import repository.entity.UserEntity;
import repository.impl.UserRepositoryImple;

@ApplicationScoped
public class UserService {
    @Inject
    UserRepositoryImple userRepositoryImple;

    public List<UserEntity> list(){
        var result = userRepositoryImple.list();
        return result;
    }
}
