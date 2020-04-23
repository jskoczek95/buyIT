package com.project.buyit.bidding.infrastructure.output;

import lombok.Value;

import java.math.BigDecimal;
import java.util.UUID;

@Value
public class OfferQueryDto {

    UUID id;
    String title;
    String description;
    BigDecimal price;
}
