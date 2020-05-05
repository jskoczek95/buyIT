package com.project.buyit.infrastructure.offers.persistence;

import com.project.buyit.infrastructure.bidding.persistence.BidEntity;
import com.project.buyit.infrastructure.users.persistence.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "offers")
@AllArgsConstructor
@NoArgsConstructor
public class OfferEntity {

    @Id
    @GeneratedValue
    private UUID id;
    private String title;
    private String description;
    private BigDecimal startingPrice;
    private LocalDateTime expirationDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity creator;
    @OneToMany(mappedBy = "offer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BidEntity> bids;
}
