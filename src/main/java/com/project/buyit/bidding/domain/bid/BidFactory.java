package com.project.buyit.bidding.domain.bid;

import com.project.buyit.bidding.domain.offer.Offer;
import com.project.buyit.bidding.domain.offer.OfferingDataProvider;
import com.project.buyit.user.domain.UserDataProvider;
import com.project.buyit.user.domain.UserDomain;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class BidFactory {

    private final OfferingDataProvider offeringDataProvider;
    private final UserDataProvider userDataProvider;

    Bid create(CreateBidCommand.Input input, UUID offerId) {
        Offer offer = offeringDataProvider.findById(offerId);
        UserDomain user = userDataProvider.findById(input.getUserId());
        return new Bid(Bid.generate(), user, offer, input.getOffer(), input.getDate());
    }
}
