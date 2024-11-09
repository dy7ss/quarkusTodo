package repository;

import java.util.List;

import controller.Todo2;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import repository.entity.Todo;

@ApplicationScoped
public class TodoRepository implements PanacheRepository<Todo>{

    public List<Todo> findAllTodos() {
        return listAll();  // Panacheのメソッドで全件取得
    }

    @Transactional
    public String create(Todo2 todo2){
        TodoMapper.toTodo(todo2).persist();
        return "OK";
    }
    
}
