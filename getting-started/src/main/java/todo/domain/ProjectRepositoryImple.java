package todo.domain;

import java.util.List;

import todo.domain.entity.Project;

public interface  ProjectRepositoryImple {
    List<Project> list(Long userId, String title);
    void create(Project todo);
    void update(Project todo);
    void delete(Long taskId);
    void changeDetailstatus(Long taskId, TaskStatus status);
    // void complete(Long taskId);
    // void cancel(Long taskId);
}
