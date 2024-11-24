package todo.repository.mapper;

import java.util.List;

import todo.domain.entity.TodoDetail;
import todo.repository.entity.TodoDetailEntity;

public class TodoDetailMapper {

    public static List<TodoDetailEntity> toDetailList(List<TodoDetail> list) {
        return list.stream().map(i -> TodoDetailEntity.builder()
        .taskName(i.getTaskName())
        .status(i.getStatus().getCode())
        .build()).toList();
    }

}
