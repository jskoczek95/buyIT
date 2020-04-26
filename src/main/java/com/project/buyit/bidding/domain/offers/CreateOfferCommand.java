package com.project.buyit.bidding.domain.offers;

import com.project.buyit.user.domain.UserDataProvider;
import com.project.buyit.user.domain.UserDomain;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.math.BigDecimal;
import java.util.UUID;

@RequiredArgsConstructor
public class CreateOfferCommand {

    private final OfferDataCommandProvider offerDataCommandProvider;
    private final UserDataProvider userDataProvider;

    public void execute(Input input, UUID creatorId) {
        UserDomain user = userDataProvider.findById(creatorId);
        Offer offer = OfferFabric.createOffer(input, user);
        offerDataCommandProvider.save(offer);
    }

    @Value
    public static class Input {
        String title;
        String description;
        Integer expirationAfterDays;
        BigDecimal startingPrice;
    }
}
