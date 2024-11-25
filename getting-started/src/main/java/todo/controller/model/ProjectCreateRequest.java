package todo.controller.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.Setter;

@Data
@Setter
public class ProjectCreateRequest {
    private Long userId;
    private String title;
    private String registerDate;
    private List<ReqProjectDetail> detailList = new ArrayList<>();
}
