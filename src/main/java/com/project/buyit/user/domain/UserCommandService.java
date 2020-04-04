package com.project.buyit.user.domain;

import com.project.buyit.user.infrastructure.entrypoint.UserRegistrationCommand;
import com.project.buyit.validation.ResponseError;
import io.vavr.control.Either;
import io.vavr.control.Option;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
class UserCommandService {

    private final UserCommandMapper commandMapper;
    private final UserDataProvider userDataProvider;
    private final PasswordEncoder passwordEncoder;

    public Either<ResponseError, UserDomain> createUser(UserRegistrationCommand userRegistrationCommand) {
        Option<UserDomain> optionUser = userDataProvider.findByEmail(userRegistrationCommand.getEmail());
        return UserValidator.validate(userRegistrationCommand, optionUser)
                .map(commandMapper::toDomain)
                .map(user -> {
                    user.setEnabled(true);
                    user.setPassword(passwordEncoder.encode(user.getPassword()));
                    return user;
                })
                .map(userDataProvider::save);
    }
}
