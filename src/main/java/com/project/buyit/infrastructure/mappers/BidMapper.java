package com.project.buyit.infrastructure.mappers;

import com.project.buyit.domain.bidding.Bid;
import com.project.buyit.domain.users.UserDataProvider.SaveUserResult;
import com.project.buyit.infrastructure.bidding.persistence.BidEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import static com.project.buyit.domain.bidding.BidDataStore.SaveBidParams;

@Mapper(componentModel = "spring", uses = {OfferMapper.class, UserMapper.class},
        injectionStrategy = InjectionStrategy.CONSTRUCTOR, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BidMapper {

    Bid toDomain(BidEntity bidEntity);

    BidEntity toEntity(Bid bid);

    SaveUserResult toSaveResult(BidEntity bidEntity);

    BidEntity toEntity(SaveBidParams bidParams);
}
