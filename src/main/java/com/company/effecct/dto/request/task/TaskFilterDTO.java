package com.company.effecct.dto.request.task;

import com.company.effecct.enums.TaskPriority;
import com.company.effecct.enums.TaskStatus;
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
public class TaskFilterDTO {
    Long profileId;
    Long taskId;
    TaskPriority priority;
    TaskStatus status;


}
