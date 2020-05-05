package com.project.buyit.domain.users;

import com.project.buyit.domain.errors.ResponseError;
import io.vavr.control.Either;
import io.vavr.control.Option;
import lombok.RequiredArgsConstructor;

import static com.project.buyit.domain.users.UserDataProvider.GetUserResult;
import static com.project.buyit.domain.users.UserDataProvider.SaveUserParams;

@RequiredArgsConstructor
final class UserValidator {

    protected static Either<ResponseError, SaveUserParams> validate(SaveUserParams input, Option<GetUserResult> userResult) {
        return userResult.isEmpty() ? Either.right(input) : Either.left(ResponseError.NOT_UNIQUE_EMAIL);
    }
}
