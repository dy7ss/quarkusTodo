package user.domain;

import java.util.List;
import java.util.Optional;

import user.domain.entity.User;

public interface UserRepositoryImple {

    public Optional<User> getById(Long id);
    public List<User> list();
} 
