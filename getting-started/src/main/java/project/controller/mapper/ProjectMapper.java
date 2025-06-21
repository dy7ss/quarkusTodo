package project.controller.mapper;

import project.controller.model.ProjectCreateRequest;
import project.controller.model.ProjectUpdateRequest;
import project.domain.entity.Project;

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
