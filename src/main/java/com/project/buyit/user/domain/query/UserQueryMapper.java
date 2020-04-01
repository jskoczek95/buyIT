package com.project.buyit.user.domain.query;

import com.project.buyit.user.domain.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
interface UserQueryMapper {

    UserDetailsQuery toDetailsQuery(User user);
}
