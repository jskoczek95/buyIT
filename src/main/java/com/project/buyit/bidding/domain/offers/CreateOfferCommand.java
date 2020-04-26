package com.project.buyit.bidding.domain.offers;

import com.project.buyit.user.domain.UserDataProvider;
import com.project.buyit.user.domain.UserDomain;
import com.project.buyit.validation.ResponseError;
import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.math.BigDecimal;
import java.util.UUID;

import static com.project.buyit.bidding.domain.offers.GetOfferQuery.Output;

@RequiredArgsConstructor
public class CreateOfferCommand {

    private final OfferDataCommandProvider offerDataCommandProvider;
    private final UserDataProvider userDataProvider;

    public Either<ResponseError, Output> execute(Input input, UUID creatorId) {
        UserDomain user = userDataProvider.findById(creatorId);
        return OfferValidator.validateOffer(input)
                .map(validatedInput -> OfferFactory.createOffer(validatedInput, user))
                .peek(offerDataCommandProvider::save)
                .map(OfferFactory::createOutput);
    }

    @Value
    public static class Input {
        String title;
        String description;
        Integer expirationAfterDays;
        BigDecimal startingPrice;
    }
}
