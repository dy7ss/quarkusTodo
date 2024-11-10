package controller.model;

import lombok.Data;
import lombok.Setter;

@Data
@Setter
public class TodoCreateRequest {
    private Long taskId;
    private String task;
    private String registerDate;
}
