package com.project.buyit.user.domain;

import com.project.buyit.user.infrastructure.entrypoint.UserDetailsQuery;
import com.project.buyit.user.infrastructure.repository.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserQueryMapper {

    UserDetailsQuery toDetailsQuery(UserDomain userDomain);

    UserDomain toDomain(UserEntity userEntity);
}
