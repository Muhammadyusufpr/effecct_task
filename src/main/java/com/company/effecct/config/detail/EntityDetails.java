package com.company.effecct.config.detail;


import com.company.effecct.dto.request.profile.CustomProfileInfoDTO;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Objects;

public class EntityDetails {
    public static CustomProfileInfoDTO getCurrentProfile() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getPrincipal().equals("anonymousUser")) {
            return null;
        }
        CustomUserDetails details = (CustomUserDetails) authentication.getPrincipal();
        return details.getProfile();
    }

    public static Long getCurrentProfileId() {
        return Objects.requireNonNull(getCurrentProfile()).getId();
    }

}
