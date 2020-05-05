package com.project.buyit.infrastructure.mappers;

import com.project.buyit.domain.offers.Offer;
import com.project.buyit.infrastructure.offers.persistence.OfferEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", uses = {UserMapper.class, BidMapper.class},
        injectionStrategy = InjectionStrategy.CONSTRUCTOR, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OfferMapper {

    Offer toDomain(OfferEntity offerEntity);

    OfferEntity toEntity(Offer offer);
}
