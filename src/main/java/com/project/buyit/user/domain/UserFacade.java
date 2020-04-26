package com.project.buyit.user.domain;

import com.project.buyit.user.infrastructure.UserMapper;
import com.project.buyit.user.infrastructure.entrypoint.UserDetailsQuery;
import com.project.buyit.user.infrastructure.entrypoint.UserRegistrationCommand;
import com.project.buyit.validation.ResponseError;
import io.vavr.control.Either;
import io.vavr.control.Option;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.UUID;

public final class UserFacade {

    private final UserQueryService userQueryService;
    private final UserCommandService userCommandService;

    public UserFacade(UserDataProvider userDataProvider, UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userQueryService = new UserQueryService(userMapper, userDataProvider);
        this.userCommandService = new UserCommandService(userMapper, userDataProvider, passwordEncoder);
    }

    public final Either<ResponseError, UserDomain> createUser(UserRegistrationCommand registrationCommand) {
        return userCommandService.createUser(registrationCommand);
    }

    public final Page<UserDetailsQuery> getAllUsers(Pageable pageable) {
        return userQueryService.getAllUsers(pageable);
    }

    public final Option<UserDetailsQuery> findById(UUID id) {
        return userQueryService.findById(id);
    }
}
