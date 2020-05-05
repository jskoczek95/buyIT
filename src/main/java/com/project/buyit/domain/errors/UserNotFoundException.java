package com.project.buyit.domain.errors;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException() {
        super("Intrusive user error! User doesn't exist in database");
    }
}
