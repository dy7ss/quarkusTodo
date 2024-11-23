package service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import repository.impl.UserRepositoryImple;

@ApplicationScoped
public class UserService {
    @Inject
    UserRepositoryImple userRepositoryImple;

    public String list(){
        var result = userRepositoryImple.list();
        return "";
    }
    
}
