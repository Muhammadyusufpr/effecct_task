package com.company.effecct.dto.response;

import com.company.effecct.entity.ProfileEntity;
import com.company.effecct.enums.ProfileRole;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

/**
 * @author 'Gapirov Muhammadyusuf' on 12/11/2023
 * @project effecct
 * @contact '@GMuhammadyusuf'
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProfileResponseDTO {
    Long id;
    String email;
    String name;
    ProfileRole role;
    LocalDateTime createdDate;


    public static ProfileResponseDTO toDTO(ProfileEntity entity) {
        return ProfileResponseDTO
                .builder()
                .id(entity.getId())
                .name(entity.getName())
                .role(entity.getRole())
                .createdDate(entity.getCreatedDate())
                .build();
    }


}
