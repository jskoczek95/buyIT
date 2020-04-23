package com.project.buyit.bidding.infrastructure;

import com.project.buyit.bidding.domain.offer.Offer;
import com.project.buyit.bidding.domain.offer.OfferingDataProvider;
import com.project.buyit.bidding.infrastructure.mappers.BiddingMapper;
import com.project.buyit.bidding.infrastructure.repository.OfferCommandRepository;
import com.project.buyit.bidding.infrastructure.repository.OfferEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class OfferingDataAdapter implements OfferingDataProvider {

    private final OfferCommandRepository commandRepository;
    private final BiddingMapper mapper;

    @Override
    @Transactional
    public Offer save(Offer offer) {
        OfferEntity offerEntity = mapper.toEntity(offer);
        commandRepository.save(offerEntity);
        return offer;
    }

    @Override
    public Offer findById(UUID id) {
        OfferEntity offerEntity = commandRepository.findById(id);
        return mapper.toDomain(offerEntity);
    }
}
