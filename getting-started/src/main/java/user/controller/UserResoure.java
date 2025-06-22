package user.controller;

import jakarta.inject.Inject;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import user.controller.dto.RestUser;
import user.controller.mapper.UserMapper;
import user.service.UserService;

@Path("/user")
public class UserResoure {
    @Inject
    UserService userSerivce;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@PathParam("id") Long id){
        var result = userSerivce.getUser(id);
        if (result.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.status(Response.Status.OK).entity(UserMapper.toUser(result.get())).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listUser(){
        var result = userSerivce.list();
        return Response.status(Response.Status.OK).entity(UserMapper.toUsers(result)).build();
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createUser(@NotNull RestUser user) {

        // return Response.status(Response.Status.OK).entity("OK").build();

        userSerivce.createUser(user);
        return Response.status(Response.Status.CREATED).build();
        }
    }
