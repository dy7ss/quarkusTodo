package service;

import java.util.List;

import controller.model.TodoCreateRequest;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import repository.TodoRepository;
import repository.entity.Todo;

@ApplicationScoped
public class TodoService {
    @Inject
    TodoRepository todoRepository;

    public List<Todo> list() {

        // var tmp = todoRepository.findById_add(1L);
        // System.out.println("tmp::" + tmp);
        // System.out.println("foo");
        // return null;
        return todoRepository.findAllTodos();

    }

    public void create(TodoCreateRequest todoCreateRequest){
        todoRepository.create(todoCreateRequest);
    }

    public Todo update(Long id, TodoCreateRequest todoCreateRequest){
        return todoRepository.update(id, todoCreateRequest);
    }

    public void delete(Long id) {
        todoRepository.delete(id);
    }
}
