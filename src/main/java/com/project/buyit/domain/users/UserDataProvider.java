package com.project.buyit.domain.users;

import io.vavr.collection.List;
import io.vavr.control.Option;
import lombok.Builder;
import lombok.Value;

import java.util.UUID;

public interface UserDataProvider {

    SaveUserResult save(SaveUserParams userParams);

    Option<GetUserResult> findByEmail(String email);

    List<GetUserResult> findAll();

    Option<GetUserResult> findById(UUID id);

    @Value
    class SaveUserParams {
        String firstName;
        String lastName;
        String email;
        String address;
        String password;
    }

    @Value
    class GetUserParams {
        UUID userId;
        String email;
    }

    @Value
    @Builder
    class SaveUserResult {
        UUID id;
        String email;
        String address;
        String firstName;
        String lastName;
        String password;
        boolean enabled;

        User toDomain() {
            return new User(id, firstName, lastName, email, address, password, enabled);
        }
    }

    @Value
    @Builder
    class GetUserResult {
        UUID id;
        String email;
        String address;
        String firstName;
        String lastName;
        boolean enabled;

        public User toDomain() {
            return new User(id, firstName, lastName, email, address, null, enabled);
        }
    }
}
