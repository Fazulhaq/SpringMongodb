package com.mcit.SpringMongodb.exception;

public class UserFilledFormNotFoundException extends RuntimeException {
    public UserFilledFormNotFoundException(Long userId) {
        super("The filled form with user id: '" + userId + "' does not exist in our records");
    }
}