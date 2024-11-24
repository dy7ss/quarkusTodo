package todo.domain;

import java.util.List;

import todo.domain.entity.Todo;

public interface  TodoRepositoryImple {
    List<Todo> list(Long userId, String title);
    void create(Todo todo);
    void update(Todo todo);
    void delete(Long taskId);
    void changeDetailstatus(Long taskId, TaskStatus status);
    // void complete(Long taskId);
    // void cancel(Long taskId);
}
