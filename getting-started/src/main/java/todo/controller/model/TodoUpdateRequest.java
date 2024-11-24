package todo.controller.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.Setter;

@Data
@Setter
public class TodoUpdateRequest {
    private String title;
    private List<TodoDetail> detailList = new ArrayList<>();
}
