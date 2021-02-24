package com.thoughtworks.capacity.gtb.mvc;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import javax.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private static final Integer MIN_PASSWORD_LENGTH = 5;
    private static final Integer MAX_PASSWORD_LENGTH = 12;

    @NotBlank(message = "username must not be null")
    @Pattern(regexp = "^[0-9a-zA-Z_]{3,10}$",message = "wrong username format")
    private String username;

    @NotBlank(message = "password must not be null")
    @Size(min = MIN_PASSWORD_LENGTH, max = MAX_PASSWORD_LENGTH,
            message = "password length out of range")
    private String password;

    @Email(message = "wrong email format")
    private String email;
}
