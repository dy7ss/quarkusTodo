package user.service;

import java.util.List;
import java.util.Optional;

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

    public Optional<User> getUser(Long id) {
        return userRepositoryImple.getById(id);
    }
}
