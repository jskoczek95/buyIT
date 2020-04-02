package com.project.buyit.user.domain.command;

import com.project.buyit.user.domain.User;
import com.project.buyit.validation.ResponseError;
import io.vavr.control.Either;

public interface UserCommandService {

    Either<ResponseError, User> createUser(UserRegistrationCommand userRegistrationCommand);
}
