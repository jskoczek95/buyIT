package com.project.buyit.user.domain.command;

import com.project.buyit.user.domain.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
interface UserCommandMapper {

    User toEntity(UserRegistrationCommand registrationCommand);
}
