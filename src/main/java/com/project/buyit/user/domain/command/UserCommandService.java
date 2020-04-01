package com.project.buyit.user.domain.command;

import com.project.buyit.user.domain.User;
import com.project.buyit.user.validation.UserError;
import io.vavr.control.Either;

public interface UserCommandService {

    Either<UserError, User> createUser(UserRegistrationCommand userRegistrationCommand);
}
