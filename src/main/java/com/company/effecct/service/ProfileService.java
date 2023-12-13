package com.company.effecct.service;

import com.company.effecct.config.detail.EntityDetails;
import com.company.effecct.dto.detail.ApiResponse;
import com.company.effecct.dto.request.profile.ProfileRequestDTO;
import com.company.effecct.dto.request.profile.ProfileUpdatePasswordDTO;
import com.company.effecct.dto.response.ProfileResponseDTO;
import com.company.effecct.entity.ProfileEntity;
import com.company.effecct.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author 'Gapirov Muhammadyusuf' on 12/11/2023
 * @project effecct
 * @contact '@GMuhammadyusuf'
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ProfileService {
    private final ProfileRepository profileRepository;
    private final PasswordEncoder passwordEncoder;

    public ApiResponse<ProfileResponseDTO> getById(String id) {
        Optional<ProfileEntity> optional = profileRepository.findById(Long.valueOf(id));
        if (optional.isEmpty()) {
            log.info("Profile not found!");
            return new ApiResponse<>("Profile not found!", 404, true);
        }
        return new ApiResponse<>("Success!", 200, false,
                optional.map(ProfileResponseDTO::toDTO).orElse(null));
    }

    public ApiResponse<?> update(Long id, ProfileRequestDTO dto) {
        Optional<ProfileEntity> optional = profileRepository.findById(id);
        if (optional.isEmpty()) {
            log.info("Profile not found!");
            return new ApiResponse<>("Profile not found!", 404, true);
        }

        ProfileEntity entity = optional.get();

        Optional<ProfileEntity> optionalEmail =
                profileRepository.findByEmailAndCreatedDateNotNull(dto.getEmail());


        if (optionalEmail.isPresent() && !id.equals(optionalEmail.get().getId())) {
            log.info("This email already exists! {}", dto.getEmail());
            return new ApiResponse<>("This email already exists!", 400, true);
        }

       int b = profileRepository.
                updateProfileDetails(dto.getName(), dto.getEmail(), entity.getId());

        if (b==0) return new ApiResponse<>("Something went wrong!", 400, true);
        return new ApiResponse<>("Successfully profile detail updated!", 200, false);
    }


    public ApiResponse<?> updatePassword(ProfileUpdatePasswordDTO dto) {
        Long profileId = EntityDetails.getCurrentProfileId();

        Optional<ProfileEntity> optional =
                profileRepository.findById(profileId);

        if (optional.isEmpty()) {
            log.info("Profile not found! id = {}", profileId);
            return new ApiResponse<>("Profile not found!", 400, true);
        }

        ProfileEntity entity = optional.get();

        if (!passwordEncoder.matches(dto.getOldPassword(), entity.getPassword())) {
            log.info("Old password not equal");
            return new ApiResponse<>("Old password not equal", 400, true);
        }

        if (!dto.getNewPassword().equals(dto.getPrePassword())) {
            log.info("Profile passwords do not match");
            return new ApiResponse<>("Profile passwords do not match", 400, true);
        }

        profileRepository.updatePassword(passwordEncoder.encode(dto.getNewPassword()), profileId);
        return new ApiResponse<>("Success!", 200, false);
    }
}
