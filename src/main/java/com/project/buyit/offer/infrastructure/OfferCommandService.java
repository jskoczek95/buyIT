package com.project.buyit.offer.infrastructure;

import com.project.buyit.offer.domain.OfferDomain;
import com.project.buyit.offer.domain.OfferFacade;
import com.project.buyit.offer.infrastructure.entrypoint.OfferCreationDto;
import com.project.buyit.validation.ResponseError;
import io.vavr.control.Either;
import io.vavr.control.Option;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OfferCommandService {

    private final OfferFacade offerFacade;

    public Either<ResponseError, OfferDomain> createOffer(OfferCreationDto offer) {
        return offerFacade.createOffer(offer);
    }

    public Option<OfferDomain> findById(UUID id) {
        return offerFacade.findById(id);
    }
}
