package repository;

import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import model.Todo;

@ApplicationScoped
public class TodoRepository implements PanacheRepository<Todo>{

    public List<Todo> findAllTodos() {
        return listAll();  // Panacheのメソッドで全件取得
    }
    
}
