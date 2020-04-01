package com.project.buyit.user.domain.command;

import com.project.buyit.user.domain.User;
import org.springframework.data.repository.Repository;

import java.util.UUID;

interface UserCommandRepository extends Repository<User, UUID> {

    User save(User user);
}
