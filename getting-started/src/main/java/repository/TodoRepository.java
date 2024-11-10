package repository;

import java.util.List;

import controller.model.TodoCreateRequest;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import repository.entity.Todo;

@ApplicationScoped
public class TodoRepository implements PanacheRepository<Todo>{

    public List<Todo> findAllTodos() {
        return listAll();  // Panacheのメソッドで全件取得
    }

    @Transactional
    public void create(TodoCreateRequest todoCreateRequest){
        var tmp = TodoMapper.toTodo(todoCreateRequest);
        tmp.setTaskId(null);
        tmp.persist();
    }

    @Transactional
    public Todo update(Long id, TodoCreateRequest todoCreateRequest){

        Todo entity = Todo.findById(id);
        if (entity == null){
            throw new NotFoundException();
        }
        entity.setTaskId(id);
        entity.setTask(todoCreateRequest.getTask());
        entity.setRegisterDate(todoCreateRequest.getRegisterDate());
        return TodoMapper.toTodo(entity);
    }

    @Transactional
    public void delete(Long id){

        Todo entity = Todo.findById(id);
        if (entity == null){
            throw new NotFoundException();
        }
        entity.delete();
    }
}
