package com.project.buyit.offer.domain;

import com.project.buyit.offer.infrastructure.entrypoint.OfferCreationDto;
import com.project.buyit.validation.ResponseError;
import io.vavr.control.Either;
import io.vavr.control.Option;
import io.vavr.control.Try;

import java.util.UUID;

class OfferDomainService {

    private final OfferDataProvider offerDataProvider;

    OfferDomainService(OfferDataProvider offerDataProvider) {
        this.offerDataProvider = offerDataProvider;
    }

    private static OfferDomain toDomain(OfferCreationDto offer) {
        return new OfferDomain(offer.getTitle(), offer.getDescription(), offer.getPrice());
    }

    Either<ResponseError, OfferDomain> createOffer(OfferCreationDto offer) {
        return OfferValidator.validate(offer)
                .map(OfferDomainService::toDomain)
                .map(offerDataProvider::create);
    }

    public Option<OfferDomain> findById(UUID id) {
        return Try.ofSupplier(() -> Option.of(offerDataProvider.findById(id))).getOrElse(Option.none());
    }
}
