package todo.domain.entity;

import lombok.Builder;
import lombok.Value;
import todo.domain.TaskStatus;

@Value
@Builder
public class TodoDetail {
    private Long todoDetailId;
    private Long detailUserId;
    private String taskName;
    private TaskStatus status;
}
