package com.project.buyit.user;

import io.vavr.collection.List;
import io.vavr.control.Option;

public interface UserService {

    com.project.buyit.user.User createUser(com.project.buyit.user.UserDto userDto);

    List<com.project.buyit.user.UserDto> getAllUsers();

    Option<com.project.buyit.user.UserDto> findById(Long id);
}
