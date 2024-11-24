package todo.repository.entity;


import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "tododetail")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TodoDetailEntity extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long todoDetailId;
    private Long detailUserId;
    private String taskName;
    private String status;
    @ManyToOne
    @JoinColumn(name = "userId", insertable=false, updatable=false)
    private TodoEntity todo;
}
