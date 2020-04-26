package com.project.buyit.bidding.domain.offers;

import com.project.buyit.bidding.DateUtil;
import com.project.buyit.bidding.domain.offers.CreateOfferCommand.Input;
import com.project.buyit.user.domain.UserDomain;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

import static com.project.buyit.bidding.domain.offers.GetOfferQuery.Output;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
class OfferFactory {

    static Offer createOffer(Input input, UserDomain user) {
        LocalDateTime expirationDate = DateUtil.addDays(input.getExpirationAfterDays());
        return new Offer(generate(), input.getTitle(), input.getDescription(), user,
                expirationDate, input.getStartingPrice());
    }

    static Output createOutput(Offer offer) {
        return new Output(offer.getTitle(), offer.getDescription(), offer.getExpirationDate(),
                offer.getStartingPrice(), offer.getCreator());
    }

    private static UUID generate() {
        return UUID.randomUUID();
    }
}
