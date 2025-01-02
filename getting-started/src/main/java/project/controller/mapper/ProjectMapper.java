package project.controller.mapper;

import jakarta.validation.Valid;
import project.command.domain.entity.Project;
import project.controller.model.ProjectCreateRequest;
import project.controller.model.ProjectUpdateRequest;

public class ProjectMapper {

    public static Project toProject(ProjectCreateRequest projectCreateRequest) {
        return Project.builder()
        .userId(projectCreateRequest.getUserId())
        .title(projectCreateRequest.getTitle())
        .registerDate(projectCreateRequest.getRegisterDate())
        .taskList(TaskMapper.toTaskList(projectCreateRequest.getDetailList()))
        .build();
    }

    public static Project toProject(Long userId, ProjectUpdateRequest projectUpdateRequest) {

        return Project.builder()
        .projectId(userId)
        .userId(userId)
        .title(projectUpdateRequest.getTitle())
        .taskList(TaskMapper.toTaskList(projectUpdateRequest.getDetailList()))
        .build();
    }
    
}
