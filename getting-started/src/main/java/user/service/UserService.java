package user.service;

import java.util.List;
import java.util.Optional;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotNull;
import user.controller.dto.RestUser;
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

    @Transactional
    public void createUser(@NotNull RestUser user) {
        User newUser = User.builder()
                .userName(user.getUserName())
                .email(user.getEmail())
                .build();
        userRepositoryImple.create(newUser);
    }
}
