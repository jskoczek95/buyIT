package com.project.buyit.bidding.domain.bids;

import com.project.buyit.bidding.domain.offers.Offer;
import com.project.buyit.bidding.domain.offers.OfferDataQueryProvider;
import com.project.buyit.user.domain.UserDataProvider;
import com.project.buyit.user.domain.UserDomain;
import com.project.buyit.validation.ResponseError;
import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import static com.project.buyit.validation.ResponseError.OFFER_NOT_FOUND;

@RequiredArgsConstructor
public class CreateBidCommand {

    private final UserDataProvider userDataProvider;
    private final OfferDataQueryProvider offerDataQueryProvider;
    private final BidDataCommandProvider bidDataCommandProvider;

    public Either<ResponseError, Output> execute(Input input, UUID offerId, UUID userId) {
        UserDomain user = userDataProvider.findById(userId);
        return offerDataQueryProvider.findById(offerId)
                .toEither(OFFER_NOT_FOUND)
                .flatMap(myOffer -> BidValidator.validateBid(input)
                        .map(validatedInput -> BidFactory.createBid(validatedInput, myOffer, user))
                        .peek(bidDataCommandProvider::save)
                        .map(BidFactory::createOutput));
    }

    @Value
    public static class Input {
        BigDecimal userOffer;
        LocalDateTime date;
    }

    @Value
    public static class Output {
        BigDecimal userOffer;
        LocalDateTime date;
        Offer offer;
        UserDomain bidder;
    }
}
