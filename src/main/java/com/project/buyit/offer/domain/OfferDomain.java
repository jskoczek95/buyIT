package com.project.buyit.offer.domain;

import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
public class OfferDomain {

    private UUID id;
    private String title;
    private String description;
    private BigDecimal price;

    public OfferDomain(String title, String description, BigDecimal price) {
        this.title = title;
        this.description = description;
        this.price = price;
    }

    public OfferDomain(UUID id, String title, String description, BigDecimal price) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
    }
}
