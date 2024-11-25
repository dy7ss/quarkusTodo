package todo.repository.mapper;

import java.util.List;

import todo.domain.TaskStatus;
import todo.domain.entity.Project;
import todo.domain.entity.Task;
import todo.repository.entity.ProjectEntity;

public class ProjectMapper {
    public static ProjectEntity toTodo(Project project) {
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
                .taskId(input.getTaskId())
                .userId(input.getUserId())
                .title(input.getTitle())
                .registerDate(input.getRegisterDate())
                .detailList(input.getDetailList().stream().map(
                        i -> Task.builder()
                                .todoDetailId(i.getTodoDetailId())
                                .detailUserId(i.getDetailUserId())
                                .taskName(i.getTaskName())
                                .status(TaskStatus.fromCode(i.getStatus()))
                                .build())
                        .toList())
                .build();
    }

    public static ProjectEntity toTodoOfCreate(Project project) {
        ProjectEntity result = new ProjectEntity();
        result.setUserId(project.getUserId());
        result.setTitle(project.getTitle());
        result.setRegisterDate(project.getRegisterDate());
        result.setDetailList(TaskMapper.toDetailList(project.getDetailList()));

        System.out.println("fuu2");
        System.out.println(result);
        return result;
    }
}
