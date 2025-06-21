package project.repository.mapper;

import java.util.List;

import project.domain.entity.Project;
import project.repository.entity.ProjectEntity;
import project.repository.entity.TaskEntity;

public class ProjectMapper {
    public static ProjectEntity toProject(Project project) {
        ProjectEntity result = new ProjectEntity();
        result.setUserId(project.getUserId());
        result.setTitle(project.getTitle());
        result.setRegisterDate(project.getRegisterDate());
        return result;
    }

    public static List<Project> toProjectList(List<ProjectEntity> response, List<TaskEntity> taskList) {   
        return response.stream().map(i -> toProject(i, taskList)).toList();
    }

    public static Project toProject(ProjectEntity input, List<TaskEntity> taskList) {
        return Project.builder()
                .projectId(input.getProjectId())
                .userId(input.getUserId())
                .title(input.getTitle())
                .registerDate(input.getRegisterDate())
                .taskList(taskList.stream().filter(i -> i.getParentProjectId().equals(input.getProjectId())).map(i -> TaskResponseMapper.toTask(i)).toList())
                .build();
    }

    public static ProjectEntity toProjectOfCreate(Project project) {
        ProjectEntity result = new ProjectEntity();
        result.setUserId(project.getUserId());
        result.setTitle(project.getTitle());
        result.setRegisterDate(project.getRegisterDate());

        System.out.println("fuu2");
        System.out.println(result);
        return result;
    }
}
