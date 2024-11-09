package controller;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import repository.entity.Todo;
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

    // @GET
    // @Produces(MediaType.APPLICATION_JSON)
    // public String list(){
    //     var result = todoService.list();
    //     System.out.println(result);
    //     return CommonUtils.toJsonString(result);
    // }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Todo> list(){
        var result = todoService.list();
        System.out.println(result);
        return result;
    }

    
    // @POST
    // @Produces(MediaType.APPLICATION_JSON)
    // public String create(Todo todo){
    //     var result = todoService.list();
    //     System.out.println(result);
    //     return CommonUtils.toJsonString(result);
    // }

    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(@Valid Todo2 todo2){
        System.out.println(todo2);
        System.out.println("foo");
        var result = todoService.create(todo2);

        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response change(@PathParam("id") String id, @Valid Todo2 todo2){
        return Response.status(Response.Status.OK).entity(todo2).build();

    }
}
