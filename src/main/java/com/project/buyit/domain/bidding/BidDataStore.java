package com.project.buyit.domain.bidding;

import com.project.buyit.domain.offers.Offer;
import com.project.buyit.domain.users.User;
import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface BidDataStore {

    List<Bid> findByOfferId(UUID offerId);

    SaveBidResult save(SaveBidParams bidParams);

    @Value
    class SaveBidParams {
        Offer offer;
        User user;
        BigDecimal userOffer;
        LocalDateTime date;
    }

    @Value
    class SaveBidResult {
        UUID bidId;
        Offer offer;
        User user;
        LocalDateTime date;
        BigDecimal userOffer;

        Bid toDomain() {
            return new Bid(bidId, offer, user, date, userOffer);
        }
    }
}
