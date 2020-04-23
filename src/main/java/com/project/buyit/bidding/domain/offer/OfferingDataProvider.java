package com.project.buyit.bidding.domain.offer;

import java.util.UUID;

public interface OfferingDataProvider {

    Offer save(Offer offer);

    Offer findById(UUID id);
}
