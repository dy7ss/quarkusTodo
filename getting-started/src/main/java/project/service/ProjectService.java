package project.service;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import project.command.domain.ProjectRepositoryImple;
import project.command.domain.TaskStatus;
import project.command.domain.entity.Project;

@ApplicationScoped
public class ProjectService {
    @Inject
    ProjectRepositoryImple projectRepositoryImple;

    public List<Project> list(Long userId, String title) {
        return projectRepositoryImple.list(userId, title);
    }

    public void create(Project project){
        projectRepositoryImple.create(project);
    }

    public void update(Project project){
        projectRepositoryImple.update(project);
    }

    public void delete(Long id) {
        projectRepositoryImple.delete(id);
    }

    public void changeStatus(Long taskId, TaskStatus status){
        projectRepositoryImple.changeDetailstatus(taskId, status);
    }
}
