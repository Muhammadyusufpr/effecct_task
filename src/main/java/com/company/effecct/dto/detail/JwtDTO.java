package com.company.effecct.dto.detail;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class JwtDTO {
    private Long id;

    public JwtDTO( Long id) {
        this.id = id;
    }
}
