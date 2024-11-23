package controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import service.UserService;

@Path("/user")
public class UserResoure {
    @Inject
    UserService userSerivce;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list(){
        var result = userSerivce.list();
        return Response.status(Response.Status.OK).entity(result).build();
    }
}
