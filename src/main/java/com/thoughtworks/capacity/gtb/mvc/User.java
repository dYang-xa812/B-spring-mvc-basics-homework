package com.thoughtworks.capacity.gtb.mvc;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private final static int MIN_PASSWORD_LENGTH = 5;
    private final static int MAX_PASSWORD_LENGTH = 12;
    private final static int MIN_USERNAME_LENGTH = 3;
    private final static int MAX_USERNAME_LENGTH = 10;
    private final static String USERNAME_REGEX = "^[0-9a-zA-Z_]{3,10}$";

    private int id;

    @NotBlank(message = "username must not be null")
    @Pattern(regexp = USERNAME_REGEX,message = "wrong username format, should be combination of letters and underscores")
    @Length(min = MIN_USERNAME_LENGTH, max = MAX_USERNAME_LENGTH,
            message = "username length out of range between {min} and {max}")
    private String username;

    @NotBlank(message = "password must not be null")
    @Length(min = MIN_PASSWORD_LENGTH, max = MAX_PASSWORD_LENGTH,
            message = "password length out of range between {min} and {max}")
    private String password;

    @Email(message = "wrong email format")
    private String email;
}
