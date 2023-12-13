package com.company.effecct.config.detail;


import com.company.effecct.dto.detail.ApiResponse;
import com.company.effecct.dto.request.profile.CustomProfileInfoDTO;
import com.company.effecct.dto.response.ProfileResponseDTO;
import com.company.effecct.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    @Lazy
    @Autowired
    private ProfileService profileService;

    @Override
    public CustomUserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        ApiResponse<ProfileResponseDTO> response = profileService.getById(id);

        if (response.getIsError()) throw new UsernameNotFoundException("Profile not found!");


        ProfileResponseDTO date = response.getDate();

        CustomProfileInfoDTO profile = new CustomProfileInfoDTO();
        profile.setId(Long.valueOf(id));
        profile.setRole(date.getRole());

        return new CustomUserDetails(profile);
    }
}
