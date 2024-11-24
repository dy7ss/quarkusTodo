package domain;

import java.util.List;

import domain.entity.Todo;

public interface  TodoRepositoryImple {
    List<Todo> list(Long userId, String title);
    void create(Todo todo);
    void update(Todo todo);
    void delete(Long taskId);
    void complete(Long taskId);
    void cancel(Long taskId);
}
