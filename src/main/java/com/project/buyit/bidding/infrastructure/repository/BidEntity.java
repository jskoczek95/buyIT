package com.project.buyit.bidding.infrastructure.repository;

import com.project.buyit.user.infrastructure.repository.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@Table(name = "bids")
@AllArgsConstructor
@NoArgsConstructor
public class BidEntity {

    @Id
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "users_id")
    private UserEntity user;
    @ManyToOne
    @JoinColumn(name = "offers_id")
    private OfferEntity offer;
    private BigDecimal price;
    private LocalDateTime date;
}
