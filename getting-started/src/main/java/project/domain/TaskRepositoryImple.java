package project.domain;

import project.domain.entity.TaskStatus;

public interface TaskRepositoryImple {
    // public void update();
    public void changeStatus(Long taskId, TaskStatus status);
}
