package auth.domain;

import lombok.Value;

@Value
public class Credential {
    private String userId;
    private String password;
}
