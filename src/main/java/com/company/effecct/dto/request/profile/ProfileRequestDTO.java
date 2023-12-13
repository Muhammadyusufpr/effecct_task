package com.company.effecct.dto.request.profile;

import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

/**
 * @author 'Gapirov Muhammadyusuf' on 12/11/2023
 * @project effecct
 * @contact '@GMuhammadyusuf'
 */
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProfileRequestDTO {
    @NotBlank(message = "Name can not be a null!")
    String name;
    @NotBlank(message = "email can not be a null!")
    String email;


}
