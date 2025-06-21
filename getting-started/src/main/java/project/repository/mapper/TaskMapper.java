package project.repository.mapper;

import java.util.List;

import project.domain.entity.Task;
import project.repository.entity.TaskEntity;

public class TaskMapper {

    public static List<TaskEntity> toTaskList(List<Task> list) {
        return list.stream().map(i -> TaskEntity.builder()
        .taskName(i.getTaskName())
        .status(i.getStatus().getCode())
        .build()).toList();
    }

}
