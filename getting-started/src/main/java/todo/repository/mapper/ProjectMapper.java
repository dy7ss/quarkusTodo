package todo.repository.mapper;

import java.util.List;

import todo.domain.TaskStatus;
import todo.domain.entity.Project;
import todo.domain.entity.Task;
import todo.repository.entity.ProjectEntity;

public class ProjectMapper {
    public static ProjectEntity toTodo(Project todo) {
        ProjectEntity result = new ProjectEntity();
        result.setUserId(todo.getUserId());
        result.setTitle(todo.getTitle());
        result.setRegisterDate(todo.getRegisterDate());
        return result;
    }

    public static List<Project> toTodoList(List<ProjectEntity> response) {
        return response.stream().map(i -> toTodo(i)).toList();
    }

    public static Project toTodo(ProjectEntity input) {
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

    public static ProjectEntity toTodoOfCreate(Project todo) {
        ProjectEntity result = new ProjectEntity();
        result.setUserId(todo.getUserId());
        result.setTitle(todo.getTitle());
        result.setRegisterDate(todo.getRegisterDate());
        result.setDetailList(TaskMapper.toDetailList(todo.getDetailList()));

        System.out.println("fuu2");
        System.out.println(result);
        return result;
    }
}
