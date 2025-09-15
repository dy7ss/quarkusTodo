package auth.restapi;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import io.smallrye.jwt.auth.principal.JWTParser;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Set;

@ApplicationScoped
public class JwtUtil {

    @Inject
    JWTParser jwtParser;

    public String generateToken(String userId, Set<String> roles) {
        return io.smallrye.jwt.build.Jwt.issuer("http://localhost:8080")
                .upn(userId)
                .groups(roles)
                .expiresAt(Instant.now().plus(1, ChronoUnit.HOURS))
                .sign();
    }

    public boolean validateToken(String token) {
        try {
            var claims = jwtParser.parse(token);
            claims.getClaim("upn"); // トークンから "upn" クレームを取得
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}