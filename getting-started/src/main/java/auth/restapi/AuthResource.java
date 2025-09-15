package auth.restapi;

import java.util.Set;

import auth.model.Credential;
import auth.model.JwtToken;
import auth.service.AuthService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/auth")
public class AuthResource {
    @Inject
    JwtUtil jwtUtil;

    @Inject
    AuthService authService;

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(Credential credential) {

        var isCorrectCredential = authService.validateUser(credential.getUserId(), credential.getPassword());
        
        if (isCorrectCredential){
            String token = jwtUtil.generateToken(credential.getUserId(), Set.of("USER"));
            return Response.ok().entity(new JwtToken(token)).build();
        }

        return Response.status(Response.Status.UNAUTHORIZED).build();
    }
}
