package controller;

import java.util.List;

import controller.model.TodoCreateRequest;
import controller.model.TodoUpdateRequest;
import domain.entity.Todo;
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
import service.TodoService;

@Path("/todo")
public class TodoResource {
    @Inject
    TodoService todoService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Todo> list(@QueryParam("userId") Long userId, @QueryParam("title") String title){
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

        Todo input = Todo.builder()
        .userId(todoCreateRequest.getUserId())
        .title(todoCreateRequest.getTitle())
        .registerDate(todoCreateRequest.getRegisterDate())
        .build();

        System.out.println("input:::" + input);

        todoService.create(input);

        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/user/{userId}/task/{taskId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response change(@PathParam("userId") Long userId, @PathParam("taskId") Long taskId, @Valid TodoUpdateRequest todoUpdateRequest){

        Todo todo = Todo.builder()
        .userId(userId)
        .taskId(taskId)
        .title(todoUpdateRequest.getTitle())
        .build();
        todoService.update(todo);
        return Response.status(Response.Status.OK).entity(null).build();
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
