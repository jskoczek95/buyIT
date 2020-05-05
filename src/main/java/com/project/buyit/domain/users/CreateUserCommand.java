package com.project.buyit.domain.users;

import com.project.buyit.domain.errors.ResponseError;
import io.vavr.control.Either;
import io.vavr.control.Option;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.util.UUID;

import static com.project.buyit.domain.users.UserDataProvider.*;

@RequiredArgsConstructor
public class CreateUserCommand {

    private final UserDataProvider userDataProvider;

    public Either<ResponseError, Output> execute(Input input) {
        final SaveUserParams userParams = new SaveUserParams(input.firstName, input.lastName, input.email, input.address, input.password);
        Option<GetUserResult> optionUser = userDataProvider.findByEmail(input.getEmail());
        return UserValidator.validate(userParams, optionUser)
                .map(userDataProvider::save)
                .map(SaveUserResult::toDomain)
                .map(Output::create);
    }

    @Value
    public static class Input {
        String firstName;
        String lastName;
        String email;
        String address;
        String password;
    }

    @Value
    public static class Output {
        UUID id;
        String email;
        String address;
        String firstName;
        String lastName;
        boolean enabled;

        static Output create(User user) {
            return new Output(user.getId(),
                    user.getEmail(),
                    user.getAddress(),
                    user.getFirstName(),
                    user.getLastName(),
                    user.isEnabled());
        }
    }
}
