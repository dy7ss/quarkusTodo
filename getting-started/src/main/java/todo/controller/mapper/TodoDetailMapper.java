package todo.controller.mapper;

import java.util.List;

import todo.controller.model.ReqTodoDetail;
import todo.domain.TaskStatus;
import todo.domain.entity.TodoDetail;

public class TodoDetailMapper {

    public static List<TodoDetail> toTodoDetailList(List<ReqTodoDetail> reqList) {
            return reqList.stream().map(i -> TodoDetail.builder()
            .taskName(i.getTaskName())
            .status(TaskStatus.NOT_STARTED)
            .build()).toList();
    }
    
}
