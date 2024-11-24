package todo.domain.entity;

import java.util.ArrayList;
import java.util.List;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Todo {
    private Long taskId;
    private Long userId;
    private String title;
    private String registerDate;
    private List<TodoDetail> detailList = new ArrayList<>();
}
