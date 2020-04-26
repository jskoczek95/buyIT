package com.project.buyit.bidding.infrastructure.offers.persistence;

import com.project.buyit.bidding.domain.offers.Offer;
import com.project.buyit.bidding.domain.offers.OfferDataQueryProvider;
import com.project.buyit.bidding.infrastructure.offers.OfferMapper;
import io.vavr.control.Option;
import io.vavr.control.Try;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class OfferQueryDataAdapter implements OfferDataQueryProvider {

    private final OfferQueryRepository offerQueryRepository;
    private final OfferMapper mapper;

    @Override
    public Option<Offer> findById(UUID offerId) {
        return Try.of(() -> offerQueryRepository.findOfferById(offerId))
                .getOrElse(Option.none())
                .map(mapper::toDomain);
    }
}
