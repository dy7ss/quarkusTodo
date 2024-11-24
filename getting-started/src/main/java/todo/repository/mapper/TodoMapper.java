package todo.repository.mapper;

import java.util.List;

import todo.domain.TaskStatus;
import todo.domain.entity.Todo;
import todo.domain.entity.TodoDetail;
import todo.repository.entity.TodoEntity;

public class TodoMapper {
    public static TodoEntity toTodo(Todo todo) {
        TodoEntity result = new TodoEntity();
        result.setUserId(todo.getUserId());
        result.setTitle(todo.getTitle());
        result.setRegisterDate(todo.getRegisterDate());
        return result;
    }

    public static List<Todo> toTodoList(List<TodoEntity> response) {
        return response.stream().map(i -> toTodo(i)).toList();
    }

    public static Todo toTodo(TodoEntity input) {
        return Todo.builder()
                .taskId(input.getTaskId())
                .userId(input.getUserId())
                .title(input.getTitle())
                .registerDate(input.getRegisterDate())
                .detailList(input.getDetailList().stream().map(
                        i -> TodoDetail.builder()
                                .todoDetailId(i.getTodoDetailId())
                                .detailUserId(i.getDetailUserId())
                                .taskName(i.getTaskName())
                                .status(TaskStatus.fromCode(i.getStatus()))
                                .build())
                        .toList())
                .build();
    }

    public static TodoEntity toTodoOfCreate(Todo todo) {
        TodoEntity result = new TodoEntity();
        result.setUserId(todo.getUserId());
        result.setTitle(todo.getTitle());
        result.setRegisterDate(todo.getRegisterDate());
        result.setDetailList(TodoDetailMapper.toDetailList(todo.getDetailList()));

        System.out.println("fuu2");
        System.out.println(result);
        return result;
    }
}
