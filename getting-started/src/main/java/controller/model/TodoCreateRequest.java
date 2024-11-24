package controller.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.Setter;

@Data
@Setter
public class TodoCreateRequest {
    private Long userId;
    private String title;
    private String registerDate;
    private List<TodoDetail> detailList = new ArrayList<>();
}
