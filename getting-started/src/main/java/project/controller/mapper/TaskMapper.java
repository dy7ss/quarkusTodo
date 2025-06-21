package project.controller.mapper;

import java.util.List;

import project.controller.model.ReqProjectDetail;
import project.domain.entity.Task;
import project.domain.entity.TaskStatus;

public class TaskMapper {

    public static List<Task> toTaskList(List<ReqProjectDetail> reqList) {
            return reqList.stream().map(i -> Task.builder()
            .taskName(i.getTaskName())
            .status(TaskStatus.NOT_STARTED)
            .build()).toList();
    }
    
}
