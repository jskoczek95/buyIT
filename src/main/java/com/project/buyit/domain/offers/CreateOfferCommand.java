package com.project.buyit.domain.offers;

import com.project.buyit.domain.errors.ResponseError;
import com.project.buyit.domain.users.UserDataProvider;
import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.math.BigDecimal;
import java.util.UUID;

import static com.project.buyit.domain.offers.GetOfferQuery.Output;

@RequiredArgsConstructor
public class CreateOfferCommand {

    private final OfferDataCommandProvider offerDataCommandProvider;
    private final UserDataProvider userDataProvider;

    public Either<ResponseError, Output> execute(Input input, UUID creatorId) {
        return userDataProvider.findById(creatorId)
                .toEither(ResponseError.USER_NOT_FOUND)
                .flatMap(user -> OfferValidator.validateOffer(input)
                        .map(validatedInput -> OfferFactory.createOffer(validatedInput, user.toDomain()))
                        .peek(offerDataCommandProvider::save)
                        .map(OfferFactory::createOutput));
    }

    @Value
    public static class Input {
        String title;
        String description;
        Integer expirationAfterDays;
        BigDecimal startingPrice;
    }
}
