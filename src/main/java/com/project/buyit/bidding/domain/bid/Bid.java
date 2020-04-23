package com.project.buyit.bidding.domain.bid;

import com.project.buyit.bidding.domain.offer.Offer;
import com.project.buyit.user.domain.UserDomain;
import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Value
public class Bid {

    UUID id;
    UserDomain user;
    Offer offer;
    BigDecimal price;
    LocalDateTime date;

    static UUID generate() {
        return UUID.randomUUID();
    }
}
