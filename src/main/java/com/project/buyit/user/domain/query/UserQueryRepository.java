package com.project.buyit.user.domain.query;

import com.project.buyit.user.domain.User;
import io.vavr.control.Option;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import java.util.UUID;

public interface UserQueryRepository extends Repository<User, UUID> {

    User findById(UUID id);

    Page<User> findAll(Pageable pageable);

    Option<User> findByEmail(String email);
}
