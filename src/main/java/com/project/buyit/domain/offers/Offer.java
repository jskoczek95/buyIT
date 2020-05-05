package com.project.buyit.domain.offers;

import com.project.buyit.domain.users.User;
import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Value
@Builder
public class Offer {

    UUID id;
    String title;
    String description;
    User creator;
    LocalDateTime expirationDate;
    BigDecimal startingPrice;
}
