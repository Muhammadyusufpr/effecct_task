package com.company.effecct.service.auth;

import com.company.effecct.dto.detail.ApiResponse;
import com.company.effecct.dto.detail.JwtDTO;
import com.company.effecct.dto.request.auth.AuthDTO;
import com.company.effecct.dto.request.RegistrationReqDTO;
import com.company.effecct.dto.response.AuthResDTO;
import com.company.effecct.entity.ProfileEntity;
import com.company.effecct.enums.ProfileRole;
import com.company.effecct.repository.ProfileRepository;
import com.company.effecct.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
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
public class AuthService {
    private final ProfileRepository profileRepository;
    private final PasswordEncoder passwordEncoder;

    public ApiResponse<?> registration(RegistrationReqDTO dto) {

        Optional<ProfileEntity> optional = profileRepository.findByEmailAndCreatedDateNotNull(dto.getEmail());

        if (optional.isPresent()) {
            log.info("This email already exist! email={}", dto.getEmail());
            return new ApiResponse<>("This email already exist!",
                    400, true, dto.getEmail());
        }


        ProfileEntity entity = new ProfileEntity();

        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setPassword(passwordEncoder.encode(dto.getPassword()));
        entity.setRole(ProfileRole.USER);
        entity.setCreatedDate(LocalDateTime.now());
        profileRepository.save(entity);

        AuthResDTO resDTO = new AuthResDTO();

        resDTO.setName(entity.getName());
        resDTO.setEmail(entity.getEmail());
        resDTO.setPassword(entity.getPassword());
        resDTO.setCreatedDate(entity.getCreatedDate());
        return new ApiResponse<>("Success!", 200, false, resDTO);
    }


    public ApiResponse<AuthResDTO> login(AuthDTO dto) {
        Optional<ProfileEntity> optional = profileRepository.findByEmailAndCreatedDateNotNull(dto.getEmail());

        if (optional.isEmpty()) {
            log.info("This email not found! email={}", dto.getEmail());
            return new ApiResponse<>("This email not found!",
                    400, true);
        }

        ProfileEntity entity = optional.get();

        if (!passwordEncoder.matches(dto.getPassword(), entity.getPassword())) {
            log.warn(" Password wrong! phone = {}", dto.getPassword());
            return new ApiResponse<>("Password wrong!",
                    400, true);
        }

        AuthResDTO resDTO = new AuthResDTO();

        resDTO.setName(entity.getName());
        resDTO.setEmail(entity.getEmail());
        resDTO.setCreatedDate(entity.getCreatedDate());

        JwtDTO jwtDTO = new JwtDTO();
        jwtDTO.setId(entity.getId());

        resDTO.setAccessToken(JwtUtil.encode(jwtDTO));
        return new ApiResponse<>("Success!", 200, false, resDTO);
    }
}
