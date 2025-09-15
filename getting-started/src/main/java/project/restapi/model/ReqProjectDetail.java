package project.restapi.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ReqProjectDetail {
    private String taskName;
}
