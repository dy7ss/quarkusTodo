package project.repository.mapper;

import java.util.List;

import project.command.domain.TaskStatus;
import project.command.domain.entity.Project;
import project.command.domain.entity.Task;
import project.repository.entity.ProjectEntity;

public class ProjectMapper {
    public static ProjectEntity toProject(Project project) {
        ProjectEntity result = new ProjectEntity();
        result.setUserId(project.getUserId());
        result.setTitle(project.getTitle());
        result.setRegisterDate(project.getRegisterDate());
        return result;
    }

    public static List<Project> toProjectList(List<ProjectEntity> response) {
        return response.stream().map(i -> toProject(i)).toList();
    }

    public static Project toProject(ProjectEntity input) {
        return Project.builder()
                .projectId(input.getProjectId())
                .userId(input.getUserId())
                .title(input.getTitle())
                .registerDate(input.getRegisterDate())
                .taskList(input.getTaskList().stream().map(
                        i -> Task.builder()
                                .taskId(i.getTaskId())
                                .parentProjectId(i.getParentProjectId())
                                .taskName(i.getTaskName())
                                .status(TaskStatus.fromCode(i.getStatus()))
                                .build())
                        .toList())
                .build();
    }

    public static ProjectEntity toProjectOfCreate(Project project) {
        ProjectEntity result = new ProjectEntity();
        result.setUserId(project.getUserId());
        result.setTitle(project.getTitle());
        result.setRegisterDate(project.getRegisterDate());
        result.setTaskList(TaskMapper.toTaskList(project.getTaskList()));

        System.out.println("fuu2");
        System.out.println(result);
        return result;
    }
}
