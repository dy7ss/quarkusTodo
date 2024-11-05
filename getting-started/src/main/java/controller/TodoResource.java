package controller;

import common.CommonUtils;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import service.TodoService;

@Path("/hello")
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
    @Path("/list")
    @Produces(MediaType.TEXT_PLAIN)
    public String listTodo(){
        var result = todoService.list();
        System.out.println(result);
        return CommonUtils.toJsonString(result);
    }
}
