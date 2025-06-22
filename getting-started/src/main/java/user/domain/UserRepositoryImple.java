package user.domain;

import java.util.List;
import java.util.Optional;

import jakarta.validation.Valid;
import user.domain.entity.User;

public interface UserRepositoryImple {

    public Optional<User> getById(Long id);
    public List<User> list();
    public Optional<User> create(@Valid User user);
} 
