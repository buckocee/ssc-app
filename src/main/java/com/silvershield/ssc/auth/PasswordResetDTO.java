package com.silvershield.ssc.auth;

import javax.validation.constraints.NotNull;

public class PasswordResetDTO {

    private String token;

    @NotNull
    private String password;

    @NotNull
    private String confirmPassword;
}
