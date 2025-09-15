package auth.repository;

import java.util.Optional;

import auth.domain.Credential;
import auth.domain.CredentialRepositoryImple;
import auth.repository.entity.CredentialEntity;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CredentialRepository implements CredentialRepositoryImple {
    
    @Override
    public Optional<Credential> findByUserId(String userId) {
        CredentialEntity entity = CredentialEntity.findById(userId);
        if (entity == null) {
            return Optional.empty();
        }
        return Optional.of(new Credential(entity.getUserId(), entity.getPassword()));
    }
}