package project.service;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import project.domain.ProjectRepositoryImple;
import project.domain.entity.Project;
import project.domain.entity.TaskStatus;

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
