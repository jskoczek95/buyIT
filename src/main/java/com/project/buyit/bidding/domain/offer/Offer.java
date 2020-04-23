package com.project.buyit.bidding.domain.offer;

import com.project.buyit.bidding.domain.bid.Bid;
import com.project.buyit.user.domain.UserDomain;
import io.vavr.collection.List;
import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Value
public class Offer {

    UUID id;
    String title;
    String description;
    BigDecimal startingPrice;
    LocalDateTime offerExpirationDate;
    UserDomain user;
    List<Bid> bids;

    static UUID generate() {
        return UUID.randomUUID();
    }
}
