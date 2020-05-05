package com.project.buyit.domain.bidding;

import com.project.buyit.domain.bidding.BidDataStore.SaveBidParams;
import com.project.buyit.domain.bidding.BidDataStore.SaveBidResult;
import com.project.buyit.domain.errors.OfferNotFoundException;
import com.project.buyit.domain.errors.ResponseError;
import com.project.buyit.domain.errors.UserNotFoundException;
import com.project.buyit.domain.offers.Offer;
import com.project.buyit.domain.offers.OfferDataQueryProvider;
import com.project.buyit.domain.users.User;
import com.project.buyit.domain.users.UserDataProvider;
import com.project.buyit.domain.users.UserDataProvider.GetUserResult;
import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@RequiredArgsConstructor
public class CreateBidCommand {

    private final UserDataProvider userDataProvider;
    private final OfferDataQueryProvider offerDataQueryProvider;
    private final BidDataStore dataStore;

    public Either<ResponseError, Output> execute(Input input, UUID offerId, UUID userId) {
        final SaveBidParams bidParams = createBidParams(offerId, userId, input.userOffer, input.getDate());
        return BidValidator.validateBid(bidParams)
                .map(dataStore::save)
                .map(SaveBidResult::toDomain)
                .map(Output::create);
    }

    private SaveBidParams createBidParams(UUID offerId, UUID userId, BigDecimal userOffer, LocalDateTime date) {
        Offer offer = offerDataQueryProvider.findById(offerId).getOrElseThrow(OfferNotFoundException::new);
        User user = userDataProvider.findById(userId)
                .map(GetUserResult::toDomain)
                .getOrElseThrow(UserNotFoundException::new);
        return new SaveBidParams(offer, user, userOffer, date);
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
        UUID offerId;
        UUID userId;
        UUID bidId;

        static Output create(Bid bid) {
            return new Output(bid.getUserOffer(),
                    bid.getDate(),
                    bid.getOffer().getId(),
                    bid.getUser().getId(),
                    bid.getId());
        }
    }
}
