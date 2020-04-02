package com.project.buyit.offer.domain;

import com.project.buyit.offer.infrastructure.entrypoint.OfferCreationDto;
import com.project.buyit.validation.ResponseError;
import io.vavr.control.Either;
import io.vavr.control.Option;

import java.util.UUID;

public class OfferFacade {

    private final OfferDomainService offerDomainService;

    public OfferFacade(OfferDataProvider offerDataProvider) {
        this.offerDomainService = new OfferDomainService(offerDataProvider);
    }

    public Either<ResponseError, OfferDomain> createOffer(OfferCreationDto offer) {
        return offerDomainService.createOffer(offer);
    }

    public Option<OfferDomain> findById(UUID id) {
        return offerDomainService.findById(id);
    }
}
