package com.company.effecct.dto.request.profile;

import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

/**
 * @author 'Gapirov Muhammadyusuf' on 12/11/2023
 * @project veterinary-pharmacy
 * @contact '@GMuhammadyusuf'
 */
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProfileUpdatePasswordDTO {
    @NotBlank(message = "old password can not be a null!")
    String oldPassword;

    @NotBlank(message = "new password can not be a null!")
    String newPassword;

    @NotBlank(message = "pre password can not be a null!")
    String prePassword;
}
