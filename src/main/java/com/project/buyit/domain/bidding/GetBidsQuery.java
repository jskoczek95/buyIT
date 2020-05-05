package com.project.buyit.domain.bidding;

import com.project.buyit.domain.users.User;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class GetBidsQuery {

    private final BidDataStore dataStore;

    public java.util.List<Output> findAll(UUID offerId) {
        List<Bid> bids = dataStore.findByOfferId(offerId);
        return bids.stream().map(BidFactory::createOutputForList).collect(Collectors.toList());
    }

    @Value
    public static class Output {
        User user;
        LocalDateTime date;
        BigDecimal userOffer;
    }
}
