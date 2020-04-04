package com.project.buyit.offer.infrastructure;

import com.project.buyit.offer.domain.OfferDataProvider;
import com.project.buyit.offer.domain.OfferDomain;
import com.project.buyit.offer.infrastructure.repository.OfferCommandRepository;
import com.project.buyit.offer.infrastructure.repository.OfferEntity;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class OfferDataAdapter implements OfferDataProvider {

    private OfferCommandRepository commandRepository;

    public OfferDataAdapter(OfferCommandRepository commandRepository) {
        this.commandRepository = commandRepository;
    }

    @Override
    public OfferDomain create(OfferDomain offerDomain) {
        OfferEntity offerEntity = toEntity(offerDomain);
        commandRepository.save(offerEntity);
        return offerDomain;
    }

    @Override
    public OfferDomain findById(UUID id) {
        OfferEntity offerEntity = commandRepository.findById(id);
        return toDomain(offerEntity);
    }

    private static OfferEntity toEntity(OfferDomain offer) {
        return new OfferEntity(offer.getTitle(), offer.getDescription(), offer.getStartingPrice());
    }

    private static OfferDomain toDomain(OfferEntity offerEntity) {
        return new OfferDomain(offerEntity.getTitle(), offerEntity.getDescription(), offerEntity.getPrice());
    }
}
