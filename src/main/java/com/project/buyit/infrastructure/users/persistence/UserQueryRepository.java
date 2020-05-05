package com.project.buyit.infrastructure.users.persistence;

import io.vavr.collection.List;
import io.vavr.control.Option;
import org.springframework.data.repository.Repository;

import java.util.UUID;

public interface UserQueryRepository extends Repository<UserEntity, UUID> {

    Option<UserEntity> findById(UUID id);

    List<UserEntity> findAll();

    Option<UserEntity> findByEmail(String email);
}
