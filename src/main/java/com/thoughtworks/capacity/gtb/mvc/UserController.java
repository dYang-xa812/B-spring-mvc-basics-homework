package com.thoughtworks.capacity.gtb.mvc;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //POST /register
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody @Valid User user) {
        userService.createUser(user);
    }

    //GET /login?
    @GetMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public User login(@RequestParam(name = "username") String username,@RequestParam(name = "password") String password) {
        return userService.findUserByUsernameAndPassword(username,password);
    }
}
