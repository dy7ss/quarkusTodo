package todo.controller;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import todo.controller.mapper.TaskMapper;
import todo.controller.model.ProjectCreateRequest;
import todo.controller.model.ProjectUpdateRequest;
import todo.domain.TaskStatus;
import todo.domain.entity.Project;
import todo.service.ProjectService;

@Path("/todo")
public class ProjectResource {
    @Inject
    ProjectService todoService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Project> list(@QueryParam("userId") Long userId, @QueryParam("title") String title){
        var result = todoService.list(userId, title);
        System.out.println(result);
        return result;
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(@Valid ProjectCreateRequest todoCreateRequest){
        System.out.println(todoCreateRequest);
        System.out.println("foo");

        Project input = Project.builder()
        .userId(todoCreateRequest.getUserId())
        .title(todoCreateRequest.getTitle())
        .registerDate(todoCreateRequest.getRegisterDate())
        .detailList(TaskMapper.toTodoDetailList(todoCreateRequest.getDetailList()))
        .build();

        System.out.println("input:::" + input);

        todoService.create(input);

        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/user/{userId}/task/{taskId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response change(@PathParam("userId") Long userId, @PathParam("taskId") Long taskId, @Valid ProjectUpdateRequest todoUpdateRequest){

        Project todo = Project.builder()
        .userId(userId)
        .taskId(taskId)
        .title(todoUpdateRequest.getTitle())
        .detailList(TaskMapper.toTodoDetailList(todoUpdateRequest.getDetailList()))
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
    
    @PATCH
    @Path("/taskId/{taskId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response changeStatus(@PathParam("taskId") Long taskId, @QueryParam("statusDivision") String statusDivision ){
        todoService.changeStatus(taskId, TaskStatus.fromCode(statusDivision));
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
