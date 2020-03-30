package com.project.buyit.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapper {

    private final PasswordEncoder passwordEncoder;

    User toEntity(UserDto userDto) {
        return User.builder().firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .address(userDto.getAddress())
                .email(userDto.getEmail())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .enabled(true).build();
    }

    UserDto toDto(User user) {
        return UserDto.builder().firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .address(user.getAddress()).build();
    }
}
