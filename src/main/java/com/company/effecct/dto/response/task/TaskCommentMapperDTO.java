package com.company.effecct.dto.response.task;

import com.company.effecct.enums.TaskPriority;
import com.company.effecct.enums.TaskStatus;

/**
 * @author 'Gapirov Muhammadyusuf' on 12/13/2023
 * @project effecct
 * @contact '@GMuhammadyusuf'
 */

public interface TaskCommentMapperDTO {

    Long getTcId();

    Long getTaskId();

    String getContent();

    TaskPriority getPriority();

    TaskStatus getStatus();

    Long getProfileId();

    String getName();

    String getEmail();

    String getComment();


}
