package com.project.buyit.bidding.domain.bids;

import com.project.buyit.bidding.domain.offers.Offer;
import com.project.buyit.bidding.domain.offers.OfferDataQueryProvider;
import com.project.buyit.user.domain.UserDataProvider;
import com.project.buyit.user.domain.UserDomain;
import com.project.buyit.validation.IdNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@RequiredArgsConstructor
public class CreateBidCommand {

    private final UserDataProvider userDataProvider;
    private final OfferDataQueryProvider offerDataQueryProvider;
    private final BidDataCommandProvider bidDataCommandProvider;

    public void execute(Input input, UUID offerId, UUID userId) {
        UserDomain user = userDataProvider.findById(userId);
        Offer offer = offerDataQueryProvider.findById(offerId).getOrElseThrow(IdNotFoundException::new);
        Bid bid = BidFactory.createBid(input, offer, user);
        bidDataCommandProvider.save(bid);
    }

    @Value
    public static class Input {
        BigDecimal userOffer;
        LocalDateTime date;
    }
}
