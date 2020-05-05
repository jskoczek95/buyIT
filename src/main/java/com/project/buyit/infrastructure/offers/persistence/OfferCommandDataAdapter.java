package com.project.buyit.infrastructure.offers.persistence;

import com.project.buyit.domain.offers.Offer;
import com.project.buyit.domain.offers.OfferDataCommandProvider;
import com.project.buyit.infrastructure.mappers.OfferMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
class OfferCommandDataAdapter implements OfferDataCommandProvider {

    private final OfferCommandRepository commandRepository;
    private final OfferMapper mapper;

    @Override
    public void save(Offer offer) {
        commandRepository.save(mapper.toEntity(offer));
    }
}
