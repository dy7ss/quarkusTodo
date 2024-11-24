package todo.repository;

import java.util.List;

import io.quarkus.panache.common.Parameters;
import io.quarkus.runtime.util.StringUtil;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.LockModeType;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import todo.domain.TaskStatus;
import todo.domain.TodoRepositoryImple;
import todo.domain.entity.Todo;
import todo.repository.entity.TodoDetailEntity;
import todo.repository.entity.TodoEntity;
import todo.repository.mapper.TodoMapper;

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
        System.out.println("response:::" + response);
        List<Todo> result = TodoMapper.toTodoList(response);

        return result;
    }

    @Transactional
    @Override
    public void create(Todo todo){
        
        System.out.println("fuu");
        System.out.println(todo);
        TodoEntity tmp = TodoMapper.toTodoOfCreate(todo);
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

    @Override
    @Transactional
    public void changestatus(Long taskId, TaskStatus status) {
        TodoDetailEntity entity = TodoDetailEntity.findById(taskId, LockModeType.PESSIMISTIC_WRITE);
        if (entity == null){
            throw new NotFoundException();
        }
        entity.setStatus(status.getCode());
    }
}
