package auth.service;

import java.util.Optional;

import auth.domain.Credential;
import auth.domain.CredentialRepositoryImple;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class AuthService {
    @Inject
    CredentialRepositoryImple credentialRepository;

    public boolean validateUser(String userId, String password) {
        Optional<Credential> credential = credentialRepository.findByUserId(userId);
        // 例外を返却したい
        if (credential.isEmpty()) {
            return false;
        }
        return isCorrectPassword(password, credential.get().getPassword());
    }

    private boolean isCorrectPassword(String inputPassword, String storedPassword) {
        // 実際にはハッシュ化して比較するなどの処理を行う
        return inputPassword.equals(storedPassword);
    }

}
