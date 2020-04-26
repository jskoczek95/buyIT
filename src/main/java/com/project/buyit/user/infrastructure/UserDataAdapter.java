package com.project.buyit.user.infrastructure;

import com.project.buyit.user.domain.UserDataProvider;
import com.project.buyit.user.domain.UserDomain;
import com.project.buyit.user.infrastructure.repository.UserCommandRepository;
import com.project.buyit.user.infrastructure.repository.UserEntity;
import com.project.buyit.user.infrastructure.repository.UserQueryRepository;
import io.vavr.control.Option;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
class UserDataAdapter implements UserDataProvider {

    private final UserCommandRepository commandRepository;
    private final UserQueryRepository queryRepository;
    private final UserMapper userMapper;

    @Override
    public UserDomain save(UserDomain userDomain) {
        UserEntity userEntity = userMapper.toEntity(userDomain);
        commandRepository.save(userEntity);
        return userDomain;
    }

    @Override
    public Option<UserDomain> findByEmail(String email) {
        return queryRepository.findByEmail(email).map(userMapper::toDomain);
    }

    @Override
    public Page<UserDomain> findAll(Pageable pageable) {
        return queryRepository.findAll(pageable).map(userMapper::toDomain);
    }

    @Override
    public UserDomain findById(UUID id) {
        UserEntity userEntity = queryRepository.findById(id);
        return userMapper.toDomain(userEntity);
    }
}
