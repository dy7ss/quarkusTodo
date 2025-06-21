package project.query.domain.entity;

import lombok.Builder;
import lombok.Value;
import project.domain.entity.TaskStatus;

@Value
@Builder
public class Task {
    private Long taskId;
    private Long parentProjectId;
    private String taskName;
    private TaskStatus status;
}
