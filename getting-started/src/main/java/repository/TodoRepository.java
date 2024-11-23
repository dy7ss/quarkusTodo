package repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import controller.model.TodoCreateRequest;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import repository.entity.TodoEntity;

@ApplicationScoped
public class TodoRepository implements PanacheRepository<TodoEntity>{

    public List<TodoEntity> findAllTodos(Long userId, String title) {
        Map<String, Object> params = new HashMap<>();
        params.put("userId", userId);
        params.put("title", "%" + title + "%");

        System.out.println(userId);
        System.out.println(title);

        List<TodoEntity> result = TodoEntity.list("userId = :userId and title like :title", params);
        // System.out.println(result);
        // System.out.println(result.getClass().getSimpleName());
        // System.out.println(result.stream().findFirst().get().getClass().getSimpleName());
        return result;



        // return TodoEntity.list("userId = :userId and title like :title",


        // return TodoEntity.list("userId = :userId and title = :title", params);
        // return TodoEntity.list("userId", userId);
    }


    public TodoEntity findById_add(Long id){
        return TodoEntity.findById(id);
    }

    @Transactional
    public void create(TodoCreateRequest todoCreateRequest){
        var tmp = TodoMapper.toTodo(todoCreateRequest);
        tmp.setTaskId(null);
        tmp.persist();
    }

    @Transactional
    public TodoEntity update(Long id, TodoCreateRequest todoCreateRequest){

        TodoEntity entity = TodoEntity.findById(id);
        if (entity == null){
            throw new NotFoundException();
        }
        entity.setTaskId(id);
        entity.setTitle(todoCreateRequest.getTask());
        entity.setRegisterDate(todoCreateRequest.getRegisterDate());
        return TodoMapper.toTodo(entity);
    }

    @Transactional
    public void delete(Long id){

        TodoEntity entity = TodoEntity.findById(id);
        if (entity == null){
            throw new NotFoundException();
        }
        entity.delete();
    }
}
