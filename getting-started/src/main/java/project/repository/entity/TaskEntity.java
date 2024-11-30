package project.repository.entity;


import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "task")
@Data
@EqualsAndHashCode(callSuper=true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskEntity extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskId;
    @Id
    private Long parentProjectId;
    @Id
    private Long taskUserId;
    private String taskName;
    private String status;
    // @ManyToOne
    // @JoinColumns({

    //     @JoinColumn(name = "parentProjectId", referencedColumnName = "projectId", insertable=false, updatable=false),
    //     @JoinColumn(name = "taskUserId", referencedColumnName = "userId",  insertable=false, updatable=false)
    // })
    // private ProjectEntity project;
}
