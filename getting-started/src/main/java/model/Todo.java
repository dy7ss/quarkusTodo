package model;


import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "todo")
@Data
public class Todo extends PanacheEntityBase   {
    @Id
    private String taskId;
    private String task;
    private String registerDate;

    public static Todo findById(String id){
        return find("id", id).firstResult();
    }
}
