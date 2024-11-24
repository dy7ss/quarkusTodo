package todo.controller.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ReqTodoDetail {
    private String taskName;
}
