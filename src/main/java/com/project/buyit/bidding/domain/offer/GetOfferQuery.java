package com.project.buyit.bidding.domain.offer;

import io.vavr.control.Option;
import io.vavr.control.Try;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
class GetOfferQuery {

    private final OfferingDataProvider offeringDataProvider;

    public Option<Offer> findById(UUID id) {
        return Try.ofSupplier(() -> Option.of(offeringDataProvider.findById(id))).getOrElse(Option.none());
    }
}
