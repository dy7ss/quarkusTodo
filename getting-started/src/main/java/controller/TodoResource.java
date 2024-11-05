package controller;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import model.Todo;
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
    public String create(@Valid Todo2 todo2){
        System.out.println(todo2);
        System.out.println("foo");
        return "{}";
    }
}
