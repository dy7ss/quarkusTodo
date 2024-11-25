package project.controller.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ProjectInputResponse {
    private String taskId;
    private String task;
    private String registerDate;
}
