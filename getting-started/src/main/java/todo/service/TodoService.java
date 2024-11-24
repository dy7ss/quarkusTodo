package todo.service;

import java.util.List;

import todo.domain.TodoRepositoryImple;
import todo.domain.entity.Todo;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class TodoService {
    @Inject
    TodoRepositoryImple todoRepositoryImple;

    public List<Todo> list(Long userId, String title) {
        return todoRepositoryImple.list(userId, title);
    }

    public void create(Todo todo){
        todoRepositoryImple.create(todo);
    }

    public void update(Todo todo){
        todoRepositoryImple.update(todo);
    }

    public void delete(Long id) {
        todoRepositoryImple.delete(id);
    }
}
