package project.controller;

import project.controller.model.ProjectUpdateResponse;
import project.repository.entity.ProjectEntity;

public class UpdateResponseMapper {

    public static ProjectUpdateResponse toResponse(ProjectEntity result) {
        return ProjectUpdateResponse.builder()
        .projectId(result.getProjectId())
        .task(result.getTitle())
        .registerDate(result.getRegisterDate())
        .build();
    }
}
