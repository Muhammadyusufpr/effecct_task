package com.company.effecct.dto.response.task;

import com.company.effecct.enums.TaskPriority;
import com.company.effecct.enums.TaskStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

/**
 * @author 'Gapirov Muhammadyusuf' on 12/13/2023
 * @project effecct
 * @contact '@GMuhammadyusuf'
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TaskDTO {
    Long id;
    String content;
    TaskPriority priority;
    TaskStatus status;
}
