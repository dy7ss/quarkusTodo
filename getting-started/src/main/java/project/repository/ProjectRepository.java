package project.repository;

import java.util.List;

import io.quarkus.panache.common.Parameters;
import io.quarkus.runtime.util.StringUtil;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.LockModeType;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import project.domain.ProjectRepositoryImple;
import project.domain.TaskStatus;
import project.domain.entity.Project;
import project.repository.entity.ProjectEntity;
import project.repository.entity.TaskEntity;
import project.repository.mapper.ProjectMapper;

@ApplicationScoped
public class ProjectRepository implements  ProjectRepositoryImple {

    @Override
    public List<Project> list(Long userId, String title) {
        Parameters params = Parameters.with("userId", userId);

        String query = "userId = :userId";

        if (!StringUtil.isNullOrEmpty(title)){
            query += " and title like :title";
            params.and("title", "%" + title + "%");
        }

        List<ProjectEntity> response = ProjectEntity.find(query, params).list();
        System.out.println("response:::" + response);
        List<Project> result = ProjectMapper.toProjectList(response);

        return result;
    }

    @Transactional
    @Override
    public void create(Project project){
        
        System.out.println("fuu");
        System.out.println(project);
        ProjectEntity tmp = ProjectMapper.toProjectOfCreate(project);
        tmp.persist();
    }

    @Transactional
    @Override
    public void update(Project project){

        System.out.println("hoge");
        System.out.println(project);
        ProjectEntity entity = ProjectEntity.findById(project.getProjectId());
        if (entity == null){
            throw new NotFoundException();
        }
        entity.setTitle(project.getTitle());
    }

    @Transactional
    @Override
    public void delete(Long id){

        ProjectEntity entity = ProjectEntity.findById(id);
        if (entity == null){
            throw new NotFoundException();
        }
        entity.delete();
    }

    @Override
    @Transactional
    public void changeDetailstatus(Long taskId, TaskStatus status) {
        TaskEntity entity = TaskEntity.findById(taskId, LockModeType.PESSIMISTIC_WRITE);
        if (entity == null){
            throw new NotFoundException();
        }
        entity.setStatus(status.getCode());
    }
}
