package project.service;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
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

    @Transactional
    public void create(Project project){
        projectRepositoryImple.create(project);
    }

    @Transactional
    public void update(Project project){
        projectRepositoryImple.update(project);
    }

    @Transactional
    public void delete(Long id) {
        projectRepositoryImple.delete(id);
    }

    @Transactional
    public void changeStatus(Long taskId, TaskStatus status){
        projectRepositoryImple.changeDetailstatus(taskId, status);
    }
}
