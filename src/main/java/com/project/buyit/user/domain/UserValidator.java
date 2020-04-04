package com.project.buyit.user.domain;

import com.project.buyit.user.infrastructure.entrypoint.UserRegistrationCommand;
import com.project.buyit.validation.ResponseError;
import io.vavr.control.Either;
import io.vavr.control.Option;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
final class UserValidator {

    protected static Either<ResponseError, UserRegistrationCommand> validate(UserRegistrationCommand registrationCommand, Option<UserDomain> userDomain) {
        return userDomain.isEmpty() ? Either.right(registrationCommand) : Either.left(ResponseError.NOT_UNIQUE_EMAIL);
    }
}
