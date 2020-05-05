package com.project.buyit.domain.bidding;

import com.project.buyit.domain.offers.Offer;
import com.project.buyit.domain.users.User;
import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Value
@Builder
public class Bid {

    UUID id;
    Offer offer;
    User user;
    LocalDateTime date;
    BigDecimal userOffer;
}
