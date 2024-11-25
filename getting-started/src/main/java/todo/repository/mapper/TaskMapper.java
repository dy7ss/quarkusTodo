package todo.repository.mapper;

import java.util.List;

import todo.domain.entity.Task;
import todo.repository.entity.TaskEntity;

public class TaskMapper {

    public static List<TaskEntity> toDetailList(List<Task> list) {
        return list.stream().map(i -> TaskEntity.builder()
        .taskName(i.getTaskName())
        .status(i.getStatus().getCode())
        .build()).toList();
    }

}
