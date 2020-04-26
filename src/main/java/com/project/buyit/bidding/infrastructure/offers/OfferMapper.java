package com.project.buyit.bidding.infrastructure.offers;

import com.project.buyit.bidding.domain.offers.Offer;
import com.project.buyit.bidding.infrastructure.bids.BidMapper;
import com.project.buyit.bidding.infrastructure.offers.persistence.OfferEntity;
import com.project.buyit.user.infrastructure.UserMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {UserMapper.class, BidMapper.class})
public interface OfferMapper {

    Offer toDomain(OfferEntity offerEntity);

    OfferEntity toEntity(Offer offer);
}
