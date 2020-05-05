package com.project.buyit.infrastructure.offers.persistence;

import com.project.buyit.domain.offers.Offer;
import com.project.buyit.domain.offers.OfferDataQueryProvider;
import com.project.buyit.infrastructure.mappers.OfferMapper;
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
