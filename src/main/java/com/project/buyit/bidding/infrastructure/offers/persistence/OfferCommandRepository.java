package com.project.buyit.bidding.infrastructure.offers.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OfferCommandRepository extends JpaRepository<OfferEntity, UUID> {
}
