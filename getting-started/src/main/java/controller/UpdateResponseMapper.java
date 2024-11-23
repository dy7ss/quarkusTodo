package controller;

import controller.model.TodoUpdateResponse;
import repository.entity.Todo;

public class UpdateResponseMapper {

    public static TodoUpdateResponse toResponse(Todo result) {
        return TodoUpdateResponse.builder()
        .taskId(result.getTaskId())
        .task(result.getTitle())
        .registerDate(result.getRegisterDate())
        .build();
    }
}
