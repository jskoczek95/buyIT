package com.project.buyit.bidding.domain.bids;

import com.project.buyit.bidding.domain.bids.CreateBidCommand.Input;
import com.project.buyit.bidding.domain.offers.Offer;
import com.project.buyit.user.domain.UserDomain;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
class BidFactory {

    static Bid createBid(Input input, Offer offer, UserDomain user) {
        return new Bid(generate(), offer, user, input.getDate(), input.getUserOffer());
    }

    static UUID generate() {
        return UUID.randomUUID();
    }
}
