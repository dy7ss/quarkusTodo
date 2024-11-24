package repository;

import java.util.List;

import domain.TodoRepositoryImple;
import domain.entity.Todo;
import io.quarkus.panache.common.Parameters;
import io.quarkus.runtime.util.StringUtil;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import repository.entity.TodoEntity;
import repository.mapper.TodoMapper;

@ApplicationScoped
public class TodoRepository implements  TodoRepositoryImple {

    @Override
    public List<Todo> list(Long userId, String title) {
        Parameters params = Parameters.with("userId", userId);

        String query = "userId = :userId";

        if (!StringUtil.isNullOrEmpty(title)){
            query += " and title like :title";
            params.and("title", "%" + title + "%");
        }

        List<TodoEntity> response = TodoEntity.find(query, params).list();
        List<Todo> result = TodoMapper.toTodoList(response);
        return result;
    }

    @Transactional
    @Override
    public void create(Todo todo){
        var tmp = TodoMapper.toTodo(todo);
        tmp.persist();
    }

    @Transactional
    @Override
    public void update(Todo todo){

        System.out.println("hoge");
        System.out.println(todo);
        TodoEntity entity = TodoEntity.findById(todo.getTaskId());
        if (entity == null){
            throw new NotFoundException();
        }
        entity.setTitle(todo.getTitle());
        // entity.setRegisterDate(todo.getRegisterDate());
    }

    @Transactional
    @Override
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
