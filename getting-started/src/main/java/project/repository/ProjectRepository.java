package project.repository;

import java.util.List;

import io.quarkus.panache.common.Parameters;
import io.quarkus.runtime.util.StringUtil;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.LockModeType;
import jakarta.ws.rs.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import project.domain.ProjectRepositoryImple;
import project.domain.entity.Project;
import project.domain.entity.TaskStatus;
import project.repository.entity.ProjectEntity;
import project.repository.entity.TaskEntity;
import project.repository.mapper.ProjectMapper;

@ApplicationScoped
@Slf4j
public class ProjectRepository implements ProjectRepositoryImple {

    @Override
    public List<Project> list(Long userId, String title) {
        Parameters params = Parameters.with("userId", userId);

        String query = "userId = :userId";

        if (!StringUtil.isNullOrEmpty(title)) {
            query += " and title like :title";
            params.and("title", "%" + title + "%");
        }

        List<ProjectEntity> response = ProjectEntity.find(query, params).list();

        // 仮で全件取得
        List<TaskEntity> taskList = TaskEntity.listAll();

        List<Project> result = ProjectMapper.toProjectList(response, taskList);

        return result;
    }

    @Override
    public void create(Project project){
        System.out.println(project);
        ProjectEntity projectEntity = ProjectMapper.toProjectOfCreate(project);
        projectEntity.persist();
        // N+1問題
        project.getTaskList().stream().map(i -> 
        TaskEntity.builder()
                .parentProjectId(projectEntity.getProjectId())
                .taskName(i.getTaskName())
                .status(i.getStatus().getCode())
                .build()
                ).forEach(i -> i.persist());
    }

    @Override
    public void update(Project project) {

        System.out.println("hoge");
        System.out.println(project);
        ProjectEntity entity = ProjectEntity.findById(project.getProjectId());
        if (entity == null) {
            throw new NotFoundException();
        }
        entity.setTitle(project.getTitle());
    }

    @Override
    public void delete(Long id) {

        ProjectEntity entity = ProjectEntity.findById(id);
        if (entity == null) {
            throw new NotFoundException();
        }
        entity.delete();
    }

    @Override
    public void changeDetailstatus(Long taskId, TaskStatus status) {
        TaskEntity entity = TaskEntity.findById(taskId, LockModeType.PESSIMISTIC_WRITE);
        if (entity == null) {
            throw new NotFoundException();
        }
        entity.setStatus(status.getCode());
    }
}
