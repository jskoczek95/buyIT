package com.project.buyit.user.domain;

import com.project.buyit.user.domain.command.UserRegistrationCommand;
import com.project.buyit.user.domain.query.UserQueryRepository;
import com.project.buyit.validation.ResponseError;
import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserValidator {

    private final UserQueryRepository userRepository;

    public Either<ResponseError, UserRegistrationCommand> validate(UserRegistrationCommand registrationCommand) {
        return userRepository.findByEmail(registrationCommand.getEmail()).isEmpty() ?
                Either.right(registrationCommand) : Either.left(ResponseError.NOT_UNIQUE_EMAIL);
    }
}
