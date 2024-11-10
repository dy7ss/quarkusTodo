package controller.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class TodoUpdateResponse {
    private Long taskId;
    private String task;
    private String registerDate;
}
