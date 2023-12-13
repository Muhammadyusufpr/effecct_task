package com.company.effecct.dto.response.task;

import lombok.*;
import lombok.experimental.FieldDefaults;

/**
 * @author 'Gapirov Muhammadyusuf' on 12/13/2023
 * @project effecct
 * @contact '@GMuhammadyusuf'
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProfileDTO {
    Long id;
    String email;
    String name;
}
