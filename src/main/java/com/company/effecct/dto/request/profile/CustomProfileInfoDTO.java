package com.company.effecct.dto.request.profile;


import com.company.effecct.enums.ProfileRole;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CustomProfileInfoDTO {
    private Long id;
    private ProfileRole role;
}
