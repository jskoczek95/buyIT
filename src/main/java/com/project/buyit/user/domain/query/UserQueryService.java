package com.project.buyit.user.domain.query;

import io.vavr.control.Option;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface UserQueryService {

    Page<UserDetailsQuery> getAllUsers(Pageable pageable);

    Option<UserDetailsQuery> findById(UUID id);
}
