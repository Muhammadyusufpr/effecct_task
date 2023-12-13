package com.company.effecct.controller.task;

import com.company.effecct.dto.detail.ApiResponse;
import com.company.effecct.dto.request.task.TaskRequestDTO;
import com.company.effecct.dto.response.task.TaskResponseDTO;
import com.company.effecct.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author 'Gapirov Muhammadyusuf' on 12/12/2023
 * @project effecct
 * @contact '@GMuhammadyusuf'
 */
@Slf4j
@RestController
@Tag(name = "Task Controller 🏢")
@RequiredArgsConstructor
@RequestMapping("/api/v1/task")
public class TaskController {
    private final TaskService taskService;

    @Operation(summary = "Create", description = "Method used for create task")
    @PostMapping("/create")
    public ResponseEntity<ApiResponse<?>> create(@RequestBody @Valid TaskRequestDTO dto) {
        log.info("Task create!");
        return ResponseEntity.ok(taskService.create(dto));
    }

    @Operation(summary = "GetById", description = "Method used for get task by id")
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<TaskResponseDTO>> getById(@PathVariable("id") Long id) {
        log.info("Get task by id");
        return ResponseEntity.ok(taskService.getById(id));
    }


    @Operation(summary = "Update", description = "Method used for update task")
    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse<?>> update(@PathVariable("id") Long id,
                                                 @RequestBody @Valid TaskRequestDTO dto) {
        log.info("Update task detail");
        return ResponseEntity.ok(taskService.update(id, dto));
    }

    @Operation(summary = "Delete", description = "Method used for delete task")
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Boolean>> delete(@PathVariable("id") Long id) {
        log.info("Delete task");
        return ResponseEntity.ok(taskService.delete(id));
    }


}
