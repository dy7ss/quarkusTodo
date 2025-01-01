package project.repository.entity;


import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "project")
@Data
@EqualsAndHashCode(callSuper=true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectEntity extends PanacheEntityBase   {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectId;
    private Long userId;
    private String title;
    private String registerDate;
}
