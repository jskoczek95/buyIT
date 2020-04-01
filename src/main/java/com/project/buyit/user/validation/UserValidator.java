package com.project.buyit.user.validation;

import com.project.buyit.user.domain.command.UserRegistrationCommand;
import com.project.buyit.user.domain.query.UserQueryRepository;
import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserValidator {

    private final UserQueryRepository userRepository;

    public Either<UserError, UserRegistrationCommand> validate(UserRegistrationCommand registrationCommand) {
        return userRepository.findByEmail(registrationCommand.getEmail()).isEmpty() ?
                Either.right(registrationCommand) : Either.left(UserError.NOT_UNIQUE_EMAIL);
    }
}
