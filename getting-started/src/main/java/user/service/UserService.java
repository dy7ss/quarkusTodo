package user.service;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import user.domain.UserRepositoryImple;
import user.domain.entity.User;
@ApplicationScoped
public class UserService {
    @Inject
    UserRepositoryImple userRepositoryImple;

    public List<User> list(){
        return userRepositoryImple.list();
    }
}
