package project.repository.entity;


import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.OneToMany;
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
@IdClass(ProjectKey.class)
public class ProjectEntity extends PanacheEntityBase   {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectId;
    private Long userId;
    private String title;
    private String registerDate;

    // @OneToMany
    // @JoinColumns({
    //     @JoinColumn(name = ""),
    //     @JoinColumn(name = "")
    // })
    @OneToMany
        @JoinColumns({
        @JoinColumn(name = "parentProjectId", referencedColumnName = "projectId", insertable=false, updatable=false),
        @JoinColumn(name = "taskUserId", referencedColumnName = "userId", insertable=false, updatable=false)
    })
    List<TaskEntity> taskList;
}
