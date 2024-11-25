package todo.controller.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.Setter;

@Data
@Setter
public class ProjectUpdateRequest {
    private String title;
    private List<ReqProjectDetail> detailList = new ArrayList<>();
}
