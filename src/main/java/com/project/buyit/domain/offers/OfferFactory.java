package com.project.buyit.domain.offers;

import com.project.buyit.domain.offers.CreateOfferCommand.Input;
import com.project.buyit.domain.users.User;
import com.project.buyit.domain.utils.DateUtil;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

import static com.project.buyit.domain.offers.GetOfferQuery.Output;

@RequiredArgsConstructor
class OfferFactory {

    static Offer createOffer(Input input, User user) {
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
