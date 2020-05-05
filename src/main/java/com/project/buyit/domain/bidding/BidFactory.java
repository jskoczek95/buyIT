package com.project.buyit.domain.bidding;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
class BidFactory {


    static GetBidsQuery.Output createOutputForList(Bid bid) {
        return new GetBidsQuery.Output(bid.getUser(), bid.getDate(), bid.getUserOffer());
    }

    static UUID generate() {
        return UUID.randomUUID();
    }
}
