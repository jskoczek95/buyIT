package com.project.buyit.bidding.domain.offer;

import com.project.buyit.bidding.domain.BiddingValidator;
import com.project.buyit.bidding.infrastructure.input.OfferCreationDto;
import com.project.buyit.validation.ResponseError;
import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateOfferCommand {

    private final OfferingDataProvider offeringDataProvider;
    private final OfferFactory offerFactory;

    public Either<ResponseError, Offer> execute(OfferCreationDto offer) {
        return BiddingValidator.validateOffer(offer)
                .map(offerFactory::create)
                .map(offeringDataProvider::save);
    }
}
