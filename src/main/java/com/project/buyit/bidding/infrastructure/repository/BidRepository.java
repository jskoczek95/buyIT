package com.project.buyit.bidding.infrastructure.repository;

import org.springframework.data.repository.Repository;

import java.util.UUID;

public interface BidRepository extends Repository<BidEntity, UUID> {

    BidEntity findById(UUID id);

    BidEntity findByOfferId(UUID offerId);

    BidEntity save(BidEntity bidEntity);
}
