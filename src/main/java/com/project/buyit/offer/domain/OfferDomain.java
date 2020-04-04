package com.project.buyit.offer.domain;

import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class OfferDomain {

    private UUID id;
    private String title;
    private String description;
    private BigDecimal startingPrice;
    private LocalDateTime offerExpirationDate;

    public OfferDomain(String title, String description, BigDecimal startingPrice) {
        this.title = title;
        this.description = description;
        this.startingPrice = startingPrice;
    }

    public OfferDomain(UUID id, String title, String description, BigDecimal startingPrice) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.startingPrice = startingPrice;
    }
}
