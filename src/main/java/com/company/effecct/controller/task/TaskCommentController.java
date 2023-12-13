package com.company.effecct.controller.task;

import com.company.effecct.dto.detail.ApiResponse;
import com.company.effecct.dto.request.task.TaskCommentReqDTO;
import com.company.effecct.dto.request.task.TaskFilterDTO;
import com.company.effecct.dto.response.task.TaskCommentResDTO;
import com.company.effecct.service.TaskCommentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 'Gapirov Muhammadyusuf' on 12/11/2023
 * @project effecct
 * @contact '@GMuhammadyusuf'
 */
@Slf4j
@RestController
@Tag(name = "Task Comment Controller 💬")
@RequiredArgsConstructor
@RequestMapping("/api/v1/task_comment")
public class TaskCommentController {
    private final TaskCommentService taskCommentService;

    @Operation(summary = "Create", description = "Method used for create comment for task")
    @PostMapping("")
    public ResponseEntity<ApiResponse<?>> create(@RequestBody @Valid TaskCommentReqDTO dto) {
        log.info("Create Task comment!");
        return ResponseEntity.ok(taskCommentService.create(dto));
    }

    @Operation(summary = "Get by profile id", description = "Method used for get task comment by profile id")
    @GetMapping("/{profileId}")
    public ResponseEntity<ApiResponse<List<TaskCommentResDTO>>> getByProfileId(
            @PathVariable("profileId") Long profileId) {
        log.info("Get by profile id");
        return ResponseEntity.ok(taskCommentService.getByProfileId(profileId));
    }

    @Operation(summary = "Filter comments", description = "Method used for filter comments")
    @PostMapping("/filter")
    public ResponseEntity<ApiResponse<PageImpl<TaskCommentResDTO>>> filter(@RequestBody TaskFilterDTO dto,
                                                                           @RequestParam(value = "page", defaultValue = "0") int page,
                                                                           @RequestParam(value = "size", defaultValue = "15") int size) {
        log.info("Filter comments");
        return ResponseEntity.ok(taskCommentService.filter(dto, page, size));
    }

}
