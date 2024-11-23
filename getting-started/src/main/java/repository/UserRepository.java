package repository;

import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import repository.entity.UserEntity;
import repository.impl.UserRepositoryImple;

@ApplicationScoped
public class UserRepository implements UserRepositoryImple, PanacheRepository<UserEntity> {

    @Override
    public String getById() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public List<UserEntity> list() {
        System.out.println("foo");

        var result = listAll();
        System.out.println(result);

        return null;
    }



}
