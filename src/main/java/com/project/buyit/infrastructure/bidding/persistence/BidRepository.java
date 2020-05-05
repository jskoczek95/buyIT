package com.project.buyit.infrastructure.bidding.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface BidRepository extends JpaRepository<BidEntity, UUID> {

    @Query("SELECT be FROM BidEntity be WHERE be.offer.id =:offerId ORDER BY be.userOffer DESC")
    List<BidEntity> findAllByOfferId(@Param("offerId") UUID offerId);
}
