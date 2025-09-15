package project.restapi.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ProjectUpdateResponse {
    private Long projectId;
    private String task;
    private String registerDate;
}
