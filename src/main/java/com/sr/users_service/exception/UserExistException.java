package com.sr.users_service.exception;

public class UserExistException extends RuntimeException{
    public UserExistException(String message) {
        super(message);
    }
}
