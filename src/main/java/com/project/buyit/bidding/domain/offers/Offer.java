package com.project.buyit.bidding.domain.offers;

import com.project.buyit.user.domain.UserDomain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Offer {

    private UUID id;
    private String title;
    private String description;
    private UserDomain creator;
    private LocalDateTime expirationDate;
    private BigDecimal startingPrice;
}
