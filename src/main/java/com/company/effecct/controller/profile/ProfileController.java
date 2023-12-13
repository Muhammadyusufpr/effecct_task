package com.company.effecct.controller.profile;

import com.company.effecct.dto.detail.ApiResponse;
import com.company.effecct.dto.request.profile.ProfileRequestDTO;
import com.company.effecct.dto.request.profile.ProfileUpdatePasswordDTO;
import com.company.effecct.service.ProfileService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author 'Gapirov Muhammadyusuf' on 12/11/2023
 * @project effecct
 * @contact '@GMuhammadyusuf'
 */
@Slf4j
@RestController
@Tag(name = "Profile Controller 👨‍🦱")
@RequiredArgsConstructor
@RequestMapping("/api/v1/profile")
public class ProfileController {
    private final ProfileService profileService;


    @Operation(summary = "Update", description = "Method used for update profile detail")
    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse<?>> update(@PathVariable Long id,
                                                 @RequestBody @Valid ProfileRequestDTO dto) {
        log.info("Update profile detail = {}", id);
        return ResponseEntity.ok(profileService.update(id, dto));
    }


    @Operation(summary = "Update Password", description = "Method used for update password profile")
    @PostMapping("/update-password")
    public ResponseEntity<ApiResponse<?>> updatePassword(@RequestBody ProfileUpdatePasswordDTO dto) {
        log.info("Update profile password! dto = {}", dto);
        return ResponseEntity.ok(profileService.updatePassword(dto));
    }




}
