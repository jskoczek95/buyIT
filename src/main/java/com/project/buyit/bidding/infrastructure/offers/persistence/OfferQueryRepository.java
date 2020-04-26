package com.project.buyit.bidding.infrastructure.offers.persistence;

import io.vavr.control.Option;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OfferQueryRepository extends JpaRepository<OfferEntity, UUID> {

    Option<OfferEntity> findOfferById(UUID offerId);
}
