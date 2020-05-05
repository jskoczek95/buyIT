package com.project.buyit.infrastructure.users.persistence;

import com.project.buyit.domain.users.UserDataProvider;
import com.project.buyit.infrastructure.mappers.UserMapper;
import io.vavr.collection.List;
import io.vavr.control.Option;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
class UserDataAdapter implements UserDataProvider {

    private final UserCommandRepository commandRepository;
    private final UserQueryRepository queryRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;


    @Override
    public SaveUserResult save(SaveUserParams userParams) {
        UserEntity userToSave = userMapper.toEntity(userParams);
        userToSave.setPassword(passwordEncoder.encode(userToSave.getPassword()));
        userToSave.setEnabled(true);
        commandRepository.save(userToSave);
        return SaveUserResult.builder()
                .id(userToSave.getId())
                .address(userToSave.getAddress())
                .email(userToSave.getEmail())
                .firstName(userToSave.getFirstName())
                .lastName(userToSave.getLastName())
                .password(userToSave.getPassword())
                .enabled(userToSave.isEnabled()).build();

    }

    @Override
    public Option<GetUserResult> findByEmail(String email) {
        return queryRepository.findByEmail(email).map(userMapper::toGetResult);
    }

    @Override
    public List<GetUserResult> findAll() {
        return queryRepository.findAll().map(userMapper::toGetResult);
    }

    @Override
    public Option<GetUserResult> findById(UUID id) {
        return queryRepository.findById(id).map(userMapper::toGetResult);
    }
}
