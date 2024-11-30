package project.command.domain;

import java.util.List;

import project.command.domain.entity.Project;

public interface  ProjectRepositoryImple {
    List<Project> list(Long userId, String title);
    void create(Project project);
    void update(Project project);
    void delete(Long taskId);
    void changeDetailstatus(Long taskId, TaskStatus status);
    // void complete(Long taskId);
    // void cancel(Long taskId);
}
