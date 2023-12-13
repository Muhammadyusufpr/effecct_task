package com.company.effecct.service;

import com.company.effecct.dto.detail.ApiResponse;
import com.company.effecct.dto.request.task.TaskCommentReqDTO;
import com.company.effecct.dto.request.task.TaskFilterDTO;
import com.company.effecct.dto.response.task.TaskCommentMapperDTO;
import com.company.effecct.dto.response.task.TaskCommentResDTO;
import com.company.effecct.dto.response.task.TaskMapDTO;
import com.company.effecct.entity.ProfileEntity;
import com.company.effecct.entity.TaskCommentEntity;
import com.company.effecct.entity.TaskEntity;
import com.company.effecct.repository.ProfileRepository;
import com.company.effecct.repository.TaskCommentRepository;
import com.company.effecct.repository.TaskRepository;
import com.company.effecct.repository.filter.TaskCommentFilterRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * @author 'Gapirov Muhammadyusuf' on 12/11/2023
 * @project effecct
 * @contact '@GMuhammadyusuf'
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class TaskCommentService {
    private final TaskCommentRepository taskCommentRepository;
    private final TaskRepository taskRepository;
    private final ProfileRepository profileRepository;
    private final TaskCommentFilterRepository filterRepository;


    public ApiResponse<?> create(TaskCommentReqDTO dto) {
        Optional<TaskEntity> optional = taskRepository.findById(dto.getTaskId());

        if (optional.isEmpty()) {
            log.info("Task not found!");
            return new ApiResponse<>("Task not found!", 404, true);
        }

        Optional<ProfileEntity> optionalProfile = profileRepository.findById(dto.getProfileId());

        if (optionalProfile.isEmpty()) {
            log.info("Profile not found!");
            return new ApiResponse<>("Profile not found!", 404, true);
        }

        TaskCommentEntity entity = new TaskCommentEntity();

        entity.setTaskId(dto.getTaskId());
        entity.setProfileId(dto.getProfileId());
        entity.setComment(dto.getComment());
        entity.setCreatedDate(LocalDateTime.now());
        taskCommentRepository.save(entity);
        return new ApiResponse<>("Success!", 200, false);
    }


    public ApiResponse<List<TaskCommentResDTO>> getByProfileId(Long profileId) {

        List<TaskCommentMapperDTO> res = taskCommentRepository.findByProfileIdNative(profileId);

        List<TaskCommentResDTO> list = res.stream().map(TaskCommentResDTO::toDTO).toList();

        return new ApiResponse<>("Success!", 200, false, list);
    }


    public ApiResponse<PageImpl<TaskCommentResDTO>> filter(TaskFilterDTO dto, int page, int size) {
        TaskMapDTO taskMapDTO = filterRepository.taskCommentFilter(dto, page, size);

        List<TaskMapDTO> resList = taskMapDTO.getResList();

        return new ApiResponse<>("Success!", 200, false,
                new PageImpl<>(resList.stream().map(TaskCommentResDTO::toDTOFilter).toList(),
                        PageRequest.of(page, size), taskMapDTO.getCount()));
    }
}
