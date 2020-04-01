package com.project.buyit.user.domain;

import com.project.buyit.user.domain.query.UserDetailsQuery;
import com.project.buyit.user.domain.query.UserQueryService;
import io.vavr.control.Option;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

@RequiredArgsConstructor
public final class UserFacade {

    private final UserQueryService userQueryService;

    public final Page<UserDetailsQuery> getAllUsers(Pageable pageable) {
        return userQueryService.getAllUsers(pageable);
    }

    public final Option<UserDetailsQuery> findById(UUID id) {
        return userQueryService.findById(id);
    }
}
