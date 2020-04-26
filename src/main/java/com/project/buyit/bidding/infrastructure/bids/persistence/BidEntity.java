package com.project.buyit.bidding.infrastructure.bids.persistence;

import com.project.buyit.bidding.infrastructure.offers.persistence.OfferEntity;
import com.project.buyit.user.infrastructure.repository.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "bids")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BidEntity {

    @Id
    private UUID id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "offer_id")
    private OfferEntity offer;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;
    private BigDecimal userOffer;
    private LocalDateTime date;
}
