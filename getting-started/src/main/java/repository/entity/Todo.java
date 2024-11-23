package repository.entity;


import java.util.ArrayList;
import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "todo")
@Data
public class Todo extends PanacheEntityBase   {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskId;
    private Long userId;
    private String title;
    private String registerDate;

    @OneToMany(mappedBy= "detailUserId")
    // @OneToMany
    List<TodoDetail> detailList = new ArrayList<>();
}
