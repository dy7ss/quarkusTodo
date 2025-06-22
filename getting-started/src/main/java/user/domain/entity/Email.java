package user.domain.entity;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Value;   

@Value
@AllArgsConstructor
public class Email {
    @NotEmpty
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$", message = "Invalid email format")
    String email;

    public String getStringValue() {
        return email;
    }
}