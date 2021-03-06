package com.project.buyit.domain.offers;

import io.vavr.control.Option;

import java.util.UUID;

public interface OfferDataQueryProvider {

    Option<Offer> findById(UUID offerId);
}
