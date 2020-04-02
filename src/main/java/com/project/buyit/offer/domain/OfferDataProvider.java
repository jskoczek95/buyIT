package com.project.buyit.offer.domain;

import java.util.UUID;

public interface OfferDataProvider {

    OfferDomain create(OfferDomain offerDomain);

    OfferDomain findById(UUID id);
}
