package com.project.buyit.bidding.domain.bids;

import com.project.buyit.bidding.domain.offers.Offer;
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
public class Bid {

    private UUID id;
    private Offer offer;
    private UserDomain user;
    private LocalDateTime date;
    private BigDecimal userOffer;
}
