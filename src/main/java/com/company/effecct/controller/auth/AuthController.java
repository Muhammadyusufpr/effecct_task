package com.company.effecct.controller.auth;

import com.company.effecct.dto.detail.ApiResponse;
import com.company.effecct.dto.request.auth.AuthDTO;
import com.company.effecct.dto.request.RegistrationReqDTO;
import com.company.effecct.dto.response.AuthResDTO;
import com.company.effecct.service.auth.AuthService;
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
@Tag(name = "Auth Controller 💬")
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;

    @Operation(summary = "Registration", description = "Method used for registration")
    @PostMapping("/registration")
    public ResponseEntity<ApiResponse<?>> registration(@RequestBody @Valid RegistrationReqDTO dto) {
        log.info("Registration dto = {}", dto);
        return ResponseEntity.ok(authService.registration(dto));
    }


    @Operation(summary = "login", description = "Method used for login")
    @PostMapping("/login")
    public ResponseEntity<ApiResponse<AuthResDTO>> login(@RequestBody @Valid AuthDTO dto) {
        log.info("login user dto = {}", dto);
        return ResponseEntity.ok(authService.login(dto));
    }


}
