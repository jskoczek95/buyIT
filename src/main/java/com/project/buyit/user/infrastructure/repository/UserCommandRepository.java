package com.project.buyit.user.infrastructure.repository;

import org.springframework.data.repository.Repository;

import java.util.UUID;

public interface UserCommandRepository extends Repository<UserEntity, UUID> {

    UserEntity save(UserEntity userEntity);
}
