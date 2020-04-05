package com.project.buyit.user.domain;

import com.project.buyit.user.infrastructure.entrypoint.UserDetailsQuery;
import io.vavr.control.Option;
import io.vavr.control.Try;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

@RequiredArgsConstructor
class UserQueryService {

    private final UserQueryMapper queryMapper;
    private final UserDataProvider userDataProvider;

    public Page<UserDetailsQuery> getAllUsers(Pageable pageable) {
        return userDataProvider.findAll(pageable).map(queryMapper::toDetailsQuery);
    }

    public Option<UserDetailsQuery> findById(UUID id) {
        return Try.ofSupplier(() -> Option.of(userDataProvider.findById(id))).getOrElse(Option.none())
                .map(queryMapper::toDetailsQuery);
    }
}
