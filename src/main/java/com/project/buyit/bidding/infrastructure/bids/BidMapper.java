package com.project.buyit.bidding.infrastructure.bids;

import com.project.buyit.bidding.domain.bids.Bid;
import com.project.buyit.bidding.infrastructure.bids.persistence.BidEntity;
import com.project.buyit.bidding.infrastructure.offers.OfferMapper;
import com.project.buyit.user.infrastructure.UserMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {OfferMapper.class, UserMapper.class})
public interface BidMapper {

    Bid toDomain(BidEntity bidEntity);

    BidEntity toEntity(Bid bid);
}
