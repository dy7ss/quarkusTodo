package repository;

import controller.Todo2;
import repository.entity.Todo;

public class TodoMapper {
    public static Todo toTodo(Todo2 todo2){
        Todo result = new Todo();
        result.setTaskId(todo2.getTaskId());
        result.setTask(todo2.getTask());
        result.setRegisterDate(todo2.getRegisterDate());
        return result;
    }
}
