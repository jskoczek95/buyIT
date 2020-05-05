package com.project.buyit.infrastructure.mappers;

import com.project.buyit.domain.users.User;
import com.project.buyit.infrastructure.users.persistence.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import static com.project.buyit.domain.users.UserDataProvider.GetUserResult;
import static com.project.buyit.domain.users.UserDataProvider.SaveUserParams;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {OfferMapper.class, BidMapper.class})
public interface UserMapper {

    User toDomain(UserEntity userEntity);

    UserEntity toEntity(SaveUserParams userParams);

    GetUserResult toGetResult(UserEntity userEntity);
}
