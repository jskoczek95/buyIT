package com.project.buyit.user.domain.command;

import com.project.buyit.user.domain.User;
import com.project.buyit.user.validation.UserError;
import com.project.buyit.user.validation.UserValidator;
import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
class UserCommandServiceImpl implements UserCommandService {

    private final UserCommandMapper commandMapper;
    private final UserCommandRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserValidator userValidator;

    @Override
    public Either<UserError, User> createUser(UserRegistrationCommand userRegistrationCommand) {
        return userValidator.validate(userRegistrationCommand)
                .map(commandMapper::toEntity)
                .map(user -> {
                    user.setEnabled(true);
                    user.setPassword(passwordEncoder.encode(user.getPassword()));
                    return user;
                })
                .map(userRepository::save);
    }
}
