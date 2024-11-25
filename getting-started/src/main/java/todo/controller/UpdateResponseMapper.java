package todo.controller;

import todo.controller.model.ProjectUpdateResponse;
import todo.repository.entity.ProjectEntity;

public class UpdateResponseMapper {

    public static ProjectUpdateResponse toResponse(ProjectEntity result) {
        return ProjectUpdateResponse.builder()
        .taskId(result.getTaskId())
        .task(result.getTitle())
        .registerDate(result.getRegisterDate())
        .build();
    }
}
