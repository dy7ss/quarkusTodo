package project.repository;

import jakarta.ws.rs.NotFoundException;
import project.command.domain.TaskRepositoryImple;
import project.command.domain.TaskStatus;
import project.repository.entity.TaskEntity;

public class TaskRepository implements TaskRepositoryImple {

    @Override
    public void changeStatus(Long taskId, TaskStatus status) {
        // 排他ロック
        TaskEntity entity = TaskEntity.findById(taskId);
        if (entity == null){
            throw new NotFoundException();
        }
        entity.setStatus(status.getCode());
    }

    // @Override
    // public void update() {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'update'");
    // }

    // @Override
    // public void changestatus(Long taskId, TaskStatus status) {
    //     TodoDetailEntity entity = TodoDetailEntity.findById(taskId);
    //     entity.setStatus(status.getCode());
    // }
}
