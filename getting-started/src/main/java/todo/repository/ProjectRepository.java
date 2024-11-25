package todo.repository;

import java.util.List;

import io.quarkus.panache.common.Parameters;
import io.quarkus.runtime.util.StringUtil;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.LockModeType;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import todo.domain.ProjectRepositoryImple;
import todo.domain.TaskStatus;
import todo.domain.entity.Project;
import todo.repository.entity.TaskEntity;
import todo.repository.entity.ProjectEntity;
import todo.repository.mapper.ProjectMapper;

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
    public void create(Project todo){
        
        System.out.println("fuu");
        System.out.println(todo);
        ProjectEntity tmp = ProjectMapper.toTodoOfCreate(todo);
        tmp.persist();
    }

    @Transactional
    @Override
    public void update(Project todo){

        System.out.println("hoge");
        System.out.println(todo);
        ProjectEntity entity = ProjectEntity.findById(todo.getTaskId());
        if (entity == null){
            throw new NotFoundException();
        }
        entity.setTitle(todo.getTitle());
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
