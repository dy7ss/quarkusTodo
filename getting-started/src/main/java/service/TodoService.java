package service;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import model.Todo;
import repository.TodoRepository;

@ApplicationScoped
public class TodoService {
    @Inject
    TodoRepository todoRepository;

    public List<Todo> list() {
        return todoRepository.findAllTodos();
    }


}
