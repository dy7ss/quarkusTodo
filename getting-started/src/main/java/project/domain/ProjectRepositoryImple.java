package project.domain;

import java.util.List;

import project.domain.entity.Project;
import project.domain.entity.TaskStatus;

public interface  ProjectRepositoryImple {
    List<Project> list(Long userId, String title);
    void create(Project project);
    void update(Project project);
    void delete(Long taskId);
    void changeDetailstatus(Long taskId, TaskStatus status);
    // void complete(Long taskId);
    // void cancel(Long taskId);
}
