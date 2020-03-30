package com.project.buyit.user;

import io.vavr.collection.List;
import io.vavr.control.Option;
import io.vavr.control.Try;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public User createUser(UserDto userDto) {
        User createdUser = userMapper.toEntity(userDto);
        return userRepository.save(createdUser);
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll().map(userMapper::toDto);
    }

    @Override
    public Option<UserDto> findById(Long id) {
        return Try.ofSupplier(() -> Option.of(userRepository.findById(id))).getOrElse(Option.none())
                .map(userMapper::toDto);
    }
}
