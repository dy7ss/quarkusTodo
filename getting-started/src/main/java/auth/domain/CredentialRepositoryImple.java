package auth.domain;

import java.util.Optional;

public interface CredentialRepositoryImple {
    public Optional<Credential> findByUserId(String userId);
    }