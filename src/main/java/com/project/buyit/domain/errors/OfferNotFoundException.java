package com.project.buyit.domain.errors;

public class OfferNotFoundException extends RuntimeException {

    public OfferNotFoundException() {
        super("Bad offer binding!");
    }
}
