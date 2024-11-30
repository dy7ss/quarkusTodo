package project.command.domain.entity;

import lombok.Builder;
import lombok.Value;
import project.command.domain.TaskStatus;

@Value
@Builder
public class Task {
    private Long taskId;
    private Long parentProjectId;
    private String taskName;
    private TaskStatus status;
}
