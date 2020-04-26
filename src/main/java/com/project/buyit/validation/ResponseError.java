package com.project.buyit.validation;

import lombok.Getter;

@Getter
public enum ResponseError {

    NOT_UNIQUE_EMAIL(400, "User with given email already exists"),
    WRONG_PRICE_FORMAT(400, "You have provided wrong price format"),
    EMPTY_TITLE_OR_DESCRIPTION(400, "Either title or description are empty"),
    PRICE_TOO_LOW(400, "You need to provide higher bid!"),
    OFFER_NOT_FOUND(400, "Offer couldn't be found");

    private int httpCode;
    private String message;

    ResponseError(int httpCode, String message) {
        this.httpCode = httpCode;
        this.message = message;
    }
}
