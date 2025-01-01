package project.command.domain;

public interface TaskRepositoryImple {
    // public void update();
    public void changeStatus(Long taskId, TaskStatus status);
}
