package domain.entity;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class TodoDetail {
    private Long todoDetailId;
    private Long detailUserId;
    private String taskName;
    private String status;
}
