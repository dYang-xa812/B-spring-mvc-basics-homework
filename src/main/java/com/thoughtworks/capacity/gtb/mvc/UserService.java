package com.thoughtworks.capacity.gtb.mvc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserService {
    private final Map<Integer,User> users = new HashMap<>();

    public void createUser(User user) {
        if (users.values().stream().anyMatch(u ->u.getUsername().equals(user.getUsername()))) {
            throw new IllegalArgumentException("this user is already existed");
        }
        this.users.put(user.getId(),user);
    }

    public User findUserByUsernameAndPassword(String name,String password){
        final User existedUser = this.users.values().stream()
                .filter(u-> u.getUsername().equals(name))
                .filter(user -> user.getPassword().equals(password))
                .collect(Collectors.toList()).get(0);
        if (existedUser == null) {
            throw new IllegalArgumentException("login failure: wrong username or password");
        }
        return existedUser;
    }
}
