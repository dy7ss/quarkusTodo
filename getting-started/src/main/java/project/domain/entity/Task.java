package project.domain.entity;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Task {
    private Long taskId;
    private Long parentProjectId;
    private String taskName;
    private TaskStatus status;
}
