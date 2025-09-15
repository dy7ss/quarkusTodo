package auth.repository.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "Credential")
@Data
@EqualsAndHashCode(callSuper=true)
public class CredentialEntity extends PanacheEntityBase {
    @Id
    private String userId;
    private String password;
}
