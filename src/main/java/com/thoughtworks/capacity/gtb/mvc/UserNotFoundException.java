package com.thoughtworks.capacity.gtb.mvc;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String message) {
        super(message);
    }
}
