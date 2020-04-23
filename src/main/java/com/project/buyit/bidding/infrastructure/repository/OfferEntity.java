package com.project.buyit.bidding.infrastructure.repository;

import com.project.buyit.user.infrastructure.repository.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "offers")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OfferEntity {

    @Id
    private UUID id;
    private String title;
    private String description;
    private BigDecimal price;
    @OneToMany(mappedBy = "offer")
    private List<BidEntity> bids = new ArrayList<>();

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "users_id")
    private UserEntity user;
}
