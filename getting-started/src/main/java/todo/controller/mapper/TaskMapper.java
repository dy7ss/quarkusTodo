package todo.controller.mapper;

import java.util.List;

import todo.controller.model.ReqProjectDetail;
import todo.domain.TaskStatus;
import todo.domain.entity.Task;

public class TaskMapper {

    public static List<Task> toTodoDetailList(List<ReqProjectDetail> reqList) {
            return reqList.stream().map(i -> Task.builder()
            .taskName(i.getTaskName())
            .status(TaskStatus.NOT_STARTED)
            .build()).toList();
    }
    
}
