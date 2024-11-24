package repository;

import java.util.List;

import controller.model.TodoCreateRequest;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;
import io.quarkus.runtime.util.StringUtil;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import repository.entity.TodoEntity;

@ApplicationScoped
public class TodoRepository implements PanacheRepository<TodoEntity>{

    public List<TodoEntity> findAllTodos(Long userId, String title) {
        Parameters params = Parameters.with("userId", userId);

        String query = "userId = :userId";

        if (!StringUtil.isNullOrEmpty(title)){
            query += " and title like :title";
            params.and("title", "%" + title + "%");
        }

        List<TodoEntity> result = find(query, params).list();
        return result;
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

    @Transactional
    public void complete(Long todoDtailId){

    }

    @Transactional
    public void cancel(Long todoDtailId){
        
    }
}
