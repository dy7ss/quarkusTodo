package service;

import java.util.List;

import controller.Todo2;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import repository.TodoRepository;
import repository.entity.Todo;

@ApplicationScoped
public class TodoService {
    @Inject
    TodoRepository todoRepository;

    public List<Todo> list() {
        return todoRepository.findAllTodos();
    }

    public String create(Todo2 todo2){
        return todoRepository.create(todo2);
    }


}
