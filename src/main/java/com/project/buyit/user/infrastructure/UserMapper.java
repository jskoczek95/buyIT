package com.project.buyit.user.infrastructure;

import com.project.buyit.bidding.infrastructure.bids.BidMapper;
import com.project.buyit.bidding.infrastructure.offers.OfferMapper;
import com.project.buyit.user.domain.UserDomain;
import com.project.buyit.user.infrastructure.entrypoint.UserDetailsQuery;
import com.project.buyit.user.infrastructure.entrypoint.UserRegistrationCommand;
import com.project.buyit.user.infrastructure.repository.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {OfferMapper.class, BidMapper.class})
public interface UserMapper {

    UserDomain toDomain(UserEntity userEntity);

    UserEntity toEntity(UserDomain userDomain);

    UserDomain registrationToDomain(UserRegistrationCommand userRegistrationCommand);

    UserDetailsQuery toDetailsQuery(UserDomain userDomain);
}
