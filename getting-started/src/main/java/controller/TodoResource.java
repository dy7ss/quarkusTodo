package controller;

import java.util.List;

import controller.model.TodoCreateRequest;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import repository.entity.TodoEntity;
import service.TodoService;

@Path("/todo")
public class TodoResource {
    @Inject
    TodoService todoService;

    @GET
    @Path("/world")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from Quarkus REST";
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<TodoEntity> list(@QueryParam("userId") Long userId, @QueryParam("title") String title){
        var result = todoService.list(userId, title);
        System.out.println(result);
        return result;
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(@Valid TodoCreateRequest todoCreateRequest){
        System.out.println(todoCreateRequest);
        System.out.println("foo");
        todoService.create(todoCreateRequest);

        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response change(@PathParam("id") Long id, @Valid TodoCreateRequest todoCreateRequest){
        TodoEntity result = todoService.update(id, todoCreateRequest);
        return Response.status(Response.Status.OK).entity(UpdateResponseMapper.toResponse(result)).build();
    }

    
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") Long id){
        todoService.delete(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
