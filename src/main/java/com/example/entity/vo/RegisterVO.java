package com.example.entity.vo;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * author:Ben
 */
@Data
public class RegisterVO {
    @Email(message = "email can not be empty")
    private String email;
    @NotBlank(message = "password can not be empty")
    private String password;
    @NotBlank(message = "code can not be empty")
    private String code;
    @NotBlank(message = "uuid can not be empty")
    private String uuid;
    @NotBlank(message = "username can not be empty")
    private String nickName;

}
