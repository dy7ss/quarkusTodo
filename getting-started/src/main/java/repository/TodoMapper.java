package repository;

import controller.model.TodoCreateRequest;
import repository.entity.Todo;

public class TodoMapper {
    public static Todo toTodo(TodoCreateRequest todoCreateRequest){
        Todo result = new Todo();
        result.setTitle(todoCreateRequest.getTask());
        result.setRegisterDate(todoCreateRequest.getRegisterDate());
        return result;
    }

    public static Todo toTodo(Todo entity) {
        Todo result = new Todo();
        result.setTaskId(entity.getTaskId());
        result.setTitle(entity.getTitle());
        result.setRegisterDate(entity.getRegisterDate());
        return result;
    }
}
