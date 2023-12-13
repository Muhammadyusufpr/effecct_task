package com.company.effecct.service;

import com.company.effecct.dto.detail.ApiResponse;
import com.company.effecct.dto.request.task.TaskRequestDTO;
import com.company.effecct.dto.response.task.TaskResponseDTO;
import com.company.effecct.entity.TaskEntity;
import com.company.effecct.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * @author 'Gapirov Muhammadyusuf' on 12/12/2023
 * @project effecct
 * @contact '@GMuhammadyusuf'
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;


    public ApiResponse<?> create(TaskRequestDTO dto) {
        TaskEntity entity = new TaskEntity();

        entity.setContent(dto.getContent());
        entity.setPriority(dto.getPriority());
        entity.setStatus(dto.getStatus());
        entity.setCreatedDate(LocalDateTime.now());

        taskRepository.save(entity);
        return new ApiResponse<>("Success!", 200, false);
    }


    public ApiResponse<TaskResponseDTO> getById(Long id) {
        Optional<TaskEntity> optional = taskRepository.findById(id);

        if (optional.isEmpty()) {
            log.info("Task not found!");
            return new ApiResponse<>("Task not found!", 404, true);
        }
        return new ApiResponse<>("Success!", 200, false,
                optional.map(TaskResponseDTO::toDTO).orElse(null));
    }


    public ApiResponse<?> update(Long id, TaskRequestDTO dto) {
        Optional<TaskEntity> optional = taskRepository.findById(id);

        if (optional.isEmpty()) {
            log.info("Task not found!");
            return new ApiResponse<>("Task not found!", 404, true);
        }

        TaskEntity entity = optional.get();

        entity.setContent(dto.getContent());
        entity.setPriority(dto.getPriority());
        entity.setStatus(dto.getStatus());

        taskRepository.save(entity);
        return new ApiResponse<>("Success!", 200, false);
    }


    public ApiResponse<Boolean> delete(Long id) {
        Optional<TaskEntity> optional = taskRepository.findById(id);

        if (optional.isEmpty()) {
            log.info("Task not found!");
            return new ApiResponse<>("Task not found!", 404, true);
        }
        taskRepository.deleteById(id);
        return new ApiResponse<>("Success!", 200, false, true);
    }

}
