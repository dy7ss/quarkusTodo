package project.repository.entity;

import java.io.Serializable;
import lombok.Data;

@Data
public class ProjectKey  implements Serializable{
    private Long projectId;
    private Long userId;
}
