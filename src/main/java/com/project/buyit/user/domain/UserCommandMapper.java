package com.project.buyit.user.domain;

import com.project.buyit.user.infrastructure.entrypoint.UserRegistrationCommand;
import com.project.buyit.user.infrastructure.repository.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserCommandMapper {

    UserEntity toEntity(UserRegistrationCommand registrationCommand);

    UserEntity toEntity(UserDomain userDomain);

    UserDomain toDomain(UserEntity userEntity);

    UserDomain toDomain(UserRegistrationCommand registrationCommand);
}
