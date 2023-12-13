package com.company.effecct.dto.request.task;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

/**
 * @author 'Gapirov Muhammadyusuf' on 12/13/2023
 * @project effecct
 * @contact '@GMuhammadyusuf'
 */
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TaskCommentReqDTO {
    @NotNull(message = "Profile id can not be null!")
    Long profileId;
    @NotNull(message = "Task id can not be null!")
    Long taskId;

    @NotBlank(message = "comment can not be null!")
    String comment;

}
