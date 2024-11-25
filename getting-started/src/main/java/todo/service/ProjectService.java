package todo.service;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import todo.domain.ProjectRepositoryImple;
import todo.domain.TaskStatus;
import todo.domain.entity.Project;

@ApplicationScoped
public class ProjectService {
    @Inject
    ProjectRepositoryImple todoRepositoryImple;

    public List<Project> list(Long userId, String title) {
        return todoRepositoryImple.list(userId, title);
    }

    public void create(Project todo){
        todoRepositoryImple.create(todo);
    }

    public void update(Project todo){
        todoRepositoryImple.update(todo);
    }

    public void delete(Long id) {
        todoRepositoryImple.delete(id);
    }

    public void changeStatus(Long taskId, TaskStatus status){
        todoRepositoryImple.changeDetailstatus(taskId, status);
    }
}
