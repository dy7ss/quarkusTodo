package repository;

import controller.model.TodoCreateRequest;
import repository.entity.TodoEntity;

public class TodoMapper {
    public static TodoEntity toTodo(TodoCreateRequest todoCreateRequest){
        TodoEntity result = new TodoEntity();
        result.setTitle(todoCreateRequest.getTask());
        result.setRegisterDate(todoCreateRequest.getRegisterDate());
        return result;
    }

    public static TodoEntity toTodo(TodoEntity entity) {
        TodoEntity result = new TodoEntity();
        result.setTaskId(entity.getTaskId());
        result.setTitle(entity.getTitle());
        result.setRegisterDate(entity.getRegisterDate());
        return result;
    }
}
