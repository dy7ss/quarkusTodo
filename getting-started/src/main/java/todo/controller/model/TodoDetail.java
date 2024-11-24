package todo.controller.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class TodoDetail {
    private String taskName;
}
