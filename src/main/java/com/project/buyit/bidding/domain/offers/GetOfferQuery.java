package com.project.buyit.bidding.domain.offers;

import com.project.buyit.user.domain.UserDomain;
import io.vavr.control.Option;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@RequiredArgsConstructor
public class GetOfferQuery {

    private final OfferDataQueryProvider offerDataQueryProvider;

    public Option<Output> findById(UUID id) {
        return offerDataQueryProvider.findById(id)
                .map(OfferFactory::createOutput);
    }

    @Value
    public static class Output {
        String title;
        String description;
        LocalDateTime expirationDate;
        BigDecimal startingPrice;
        UserDomain creator;
    }
}
