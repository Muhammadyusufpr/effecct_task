package com.company.effecct.dto.response.task;

import com.company.effecct.entity.TaskEntity;
import com.company.effecct.enums.TaskPriority;
import com.company.effecct.enums.TaskStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

/**
 * @author 'Gapirov Muhammadyusuf' on 12/13/2023
 * @project effecct
 * @contact '@GMuhammadyusuf'
 */
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TaskResponseDTO {

    Long id;
    String content;
    TaskPriority priority;
    TaskStatus status;
    LocalDateTime createdDate;


    public static TaskResponseDTO toDTO(TaskEntity entity) {
        return TaskResponseDTO
                .builder()
                .id(entity.getId())
                .content(entity.getContent())
                .priority(entity.getPriority())
                .status(entity.getStatus())
                .createdDate(entity.getCreatedDate())
                .build();
    }



}
