package todo.repository.mapper;

import java.util.List;
import todo.domain.entity.Todo;
import todo.repository.entity.TodoEntity;

public class TodoMapper {
    public static TodoEntity toTodo(Todo todo){
        TodoEntity result = new TodoEntity();
        result.setUserId(todo.getUserId());
        result.setTitle(todo.getTitle());
        result.setRegisterDate(todo.getRegisterDate());
        return result;
    }

    public static List<Todo> toTodoList(List<TodoEntity> response) {
        return response.stream().map(i -> toTodo(i)).toList();
    }

    public static Todo toTodo(TodoEntity input){
        return Todo.builder()
        .taskId(input.getTaskId())
        .userId(input.getUserId())
        .title(input.getTitle())
        .registerDate(input.getRegisterDate())
        .build();
    }
}
