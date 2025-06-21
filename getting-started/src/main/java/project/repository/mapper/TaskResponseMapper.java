package project.repository.mapper;

import project.domain.entity.Task;
import project.domain.entity.TaskStatus;
import project.repository.entity.TaskEntity;

public class TaskResponseMapper {
    public static Task toTask(TaskEntity entity){
        return Task.builder()
                .taskId(entity.getTaskId())
                .parentProjectId(entity.getParentProjectId())
                .taskName(entity.getTaskName())
                .status(TaskStatus.fromCode(entity.getStatus()))
                .build();
    }
    
}
