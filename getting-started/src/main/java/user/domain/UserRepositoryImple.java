package user.domain;

import java.util.List;

import user.domain.entity.User;

public interface UserRepositoryImple {

    public String getById();
    public List<User> list();
} 
