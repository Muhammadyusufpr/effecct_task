package com.company.effecct.dto.response.task;

import lombok.*;
import lombok.experimental.FieldDefaults;

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
public class TaskCommentResDTO {
    Long id;
    String comment;
    ProfileDTO profile;
    TaskDTO task;

    public static TaskCommentResDTO toDTO(TaskCommentMapperDTO mapperDTO) {
        return TaskCommentResDTO
                .builder()
                .id(mapperDTO.getTcId())
                .comment(mapperDTO.getComment())
                .profile(new ProfileDTO(mapperDTO.getProfileId(), mapperDTO.getEmail(), mapperDTO.getName()))
                .task(new TaskDTO(mapperDTO.getTaskId(), mapperDTO.getContent(),
                        mapperDTO.getPriority(), mapperDTO.getStatus()))
                .build();
    }


    public static TaskCommentResDTO toDTOFilter(TaskMapDTO mapDTO) {
        return TaskCommentResDTO
                .builder()
                .id(mapDTO.getTcId())
                .comment(mapDTO.getComment())
                .profile(new ProfileDTO(mapDTO.getProfileId(), mapDTO.getEmail(), mapDTO.getName()))
                .task(new TaskDTO(mapDTO.getTaskId(), mapDTO.getContent(),
                        mapDTO.getPriority(), mapDTO.getStatus()))
                .build();
    }


}
