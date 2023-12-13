package com.company.effecct.dto.request.task;

import com.company.effecct.enums.TaskPriority;
import com.company.effecct.enums.TaskStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

/**
 * @author 'Gapirov Muhammadyusuf' on 12/12/2023
 * @project effecct
 * @contact '@GMuhammadyusuf'
 */
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TaskRequestDTO {
    @NotBlank(message = "content can not be null!")
    String content;

    @NotNull(message = "priority can not be null!")
    TaskPriority priority;

    @NotNull(message = "status can not be null!")
    TaskStatus status;


}
