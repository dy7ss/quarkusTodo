package project.controller.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ProjectUpdateResponse {
    private Long taskId;
    private String task;
    private String registerDate;
}
