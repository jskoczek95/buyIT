package com.project.buyit.user.infrastructure.repository;

import io.vavr.control.Option;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import java.util.UUID;

public interface UserQueryRepository extends Repository<UserEntity, UUID> {

    UserEntity findById(UUID id);

    Page<UserEntity> findAll(Pageable pageable);

    Option<UserEntity> findByEmail(String email);
}
