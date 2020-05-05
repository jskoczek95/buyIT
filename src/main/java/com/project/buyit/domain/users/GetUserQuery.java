package com.project.buyit.domain.users;

import io.vavr.collection.List;
import io.vavr.control.Option;
import io.vavr.control.Try;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.util.UUID;

import static com.project.buyit.domain.users.UserDataProvider.GetUserParams;
import static com.project.buyit.domain.users.UserDataProvider.GetUserResult;

@RequiredArgsConstructor
public class GetUserQuery {

    private final UserDataProvider userDataProvider;

    public List<Output> getAllUsers() {
        return userDataProvider.findAll()
                .map(GetUserResult::toDomain)
                .map(Output::create);
    }

    public Option<Output> findById(Input input) {
        final GetUserParams userParams = new GetUserParams(input.getUserId(), null);
        return Try.ofSupplier(() -> userDataProvider.findById(userParams.getUserId())).getOrElse(Option.none())
                .map(GetUserResult::toDomain)
                .map(Output::create);
    }

    @Value
    public static class Input {
        UUID userId;
        String email;

        public static Input byId(UUID userId) {
            return new Input(userId, null);
        }

        public static Input byEmail(String email) {
            return new Input(null, email);
        }
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
