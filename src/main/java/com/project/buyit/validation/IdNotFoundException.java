package com.project.buyit.validation;

public class IdNotFoundException extends RuntimeException {

    public IdNotFoundException() {
        super("Object with given id not found");
    }
}
