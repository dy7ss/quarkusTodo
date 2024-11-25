package todo.repository.entity;


import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "todo")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectEntity extends PanacheEntityBase   {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskId;
    private Long userId;
    private String title;
    private String registerDate;

    @OneToMany(mappedBy= "detailUserId")
    List<TaskEntity> detailList;
}
