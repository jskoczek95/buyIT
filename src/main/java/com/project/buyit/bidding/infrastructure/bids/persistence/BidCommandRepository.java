package com.project.buyit.bidding.infrastructure.bids.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BidCommandRepository extends JpaRepository<BidEntity, UUID> {
}
