package project.restapi.mapper;

import java.util.List;

import project.domain.entity.Task;
import project.domain.entity.TaskStatus;
import project.restapi.model.ReqProjectDetail;

public class TaskMapper {

    public static List<Task> toTaskList(List<ReqProjectDetail> reqList) {
            return reqList.stream().map(i -> Task.builder()
            .taskName(i.getTaskName())
            .status(TaskStatus.NOT_STARTED)
            .build()).toList();
    }
    
}
