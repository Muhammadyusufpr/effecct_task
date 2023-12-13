package com.company.effecct.dto.request.auth;


import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class AuthDTO {
    @NotBlank(message = "email can not be null!")
    private String email;
    @NotBlank(message = "password can not be null!")
    private String password;
}
