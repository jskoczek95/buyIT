package com.project.buyit.bidding.infrastructure.repository;

import org.springframework.data.repository.Repository;

import java.util.UUID;

@org.springframework.stereotype.Repository
public interface OfferCommandRepository extends Repository<OfferEntity, UUID> {

    OfferEntity save(OfferEntity offer);

    OfferEntity findById(UUID id);
}
