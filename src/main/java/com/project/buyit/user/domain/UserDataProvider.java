package com.project.buyit.user.domain;

import io.vavr.control.Option;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface UserDataProvider {

    UserDomain save(UserDomain userDomain);

    Option<UserDomain> findByEmail(String email);

    Page<UserDomain> findAll(Pageable pageable);

    UserDomain findById(UUID id);
}
