package project.restapi;

import project.repository.entity.ProjectEntity;
import project.restapi.model.ProjectUpdateResponse;

public class UpdateResponseMapper {

    public static ProjectUpdateResponse toResponse(ProjectEntity result) {
        return ProjectUpdateResponse.builder()
        .projectId(result.getProjectId())
        .task(result.getTitle())
        .registerDate(result.getRegisterDate())
        .build();
    }
}
