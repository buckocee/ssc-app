package com.silvershield.ssc.auth;

import com.silvershield.ssc.validator.PasswordMatches;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@PasswordMatches
public class UserDto {

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String password;

    @NotNull
    private String confirmPassword;

    private Integer role;

    @NotNull
    private String email;

}
