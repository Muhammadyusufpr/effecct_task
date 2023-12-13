package com.company.effecct.dto.response.task;

import com.company.effecct.enums.TaskPriority;
import com.company.effecct.enums.TaskStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author 'Gapirov Muhammadyusuf' on 12/13/2023
 * @project effecct
 * @contact '@GMuhammadyusuf'
 */
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TaskMapDTO {
    Long tcId;
    String comment;
    Long profileId;
    String name;
    String email;
    Long taskId;
    String content;
    TaskPriority priority;
    TaskStatus status;
    LocalDateTime createdDate;

    Long count = 0L;
    List<TaskMapDTO> resList;


    public TaskMapDTO(Long tcId,String comment,  Long profileId, String name, String email, Long taskId,
                      String content, TaskPriority priority,
                      TaskStatus status, LocalDateTime createdDate) {
        this.tcId = tcId;
        this.comment = comment;
        this.profileId = profileId;
        this.name = name;
        this.email = email;
        this.taskId = taskId;
        this.content = content;
        this.priority = priority;
        this.status = status;
        this.createdDate = createdDate;
    }

    public TaskMapDTO(Long count, List<TaskMapDTO> resList) {
        this.count = count;
        this.resList = resList;
    }
}
