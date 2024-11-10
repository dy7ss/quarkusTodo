package repository;

import controller.model.TodoCreateRequest;
import jakarta.ws.rs.NotFoundException;
import repository.entity.Todo;

public class TodoMapper {
    public static Todo toTodo(TodoCreateRequest todoCreateRequest){
        Todo result = new Todo();
        // result.setTaskId(todoInputRequest.getTaskId());
        result.setTask(todoCreateRequest.getTask());
        result.setRegisterDate(todoCreateRequest.getRegisterDate());
        return result;
    }

    public static Todo toTodo(Todo entity) {
        Todo result = new Todo();
        result.setTaskId(entity.getTaskId());
        result.setTask(entity.getTask());
        result.setRegisterDate(entity.getRegisterDate());
        return result;
    }
}
