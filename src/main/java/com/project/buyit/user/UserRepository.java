package com.project.buyit.user;

import io.vavr.collection.List;
import io.vavr.control.Option;
import org.springframework.data.repository.Repository;

public interface UserRepository extends Repository<User, Long> {

    User findById(Long id);

    List<User> findAll();

    User save(User user);

    Option<User> findByEmail(String email);
}
