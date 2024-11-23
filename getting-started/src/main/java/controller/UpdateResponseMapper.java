package controller;

import controller.model.TodoUpdateResponse;
import repository.entity.TodoEntity;

public class UpdateResponseMapper {

    public static TodoUpdateResponse toResponse(TodoEntity result) {
        return TodoUpdateResponse.builder()
        .taskId(result.getTaskId())
        .task(result.getTitle())
        .registerDate(result.getRegisterDate())
        .build();
    }
}
