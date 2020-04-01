package com.project.buyit.user.validation;

import lombok.Getter;

@Getter
public enum UserError {

    NOT_UNIQUE_EMAIL(400, "User with given email already exists");

    private int httpCode;
    private String message;

    UserError(int httpCode, String message) {
        this.httpCode = httpCode;
        this.message = message;
    }
}
