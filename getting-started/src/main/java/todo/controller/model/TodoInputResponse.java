package todo.controller.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class TodoInputResponse {
    private String taskId;
    private String task;
    private String registerDate;
}
