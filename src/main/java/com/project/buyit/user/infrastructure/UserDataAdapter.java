package com.project.buyit.user.infrastructure;

import com.project.buyit.user.domain.UserCommandMapper;
import com.project.buyit.user.domain.UserDataProvider;
import com.project.buyit.user.domain.UserDomain;
import com.project.buyit.user.domain.UserQueryMapper;
import com.project.buyit.user.infrastructure.repository.UserCommandRepository;
import com.project.buyit.user.infrastructure.repository.UserEntity;
import com.project.buyit.user.infrastructure.repository.UserQueryRepository;
import io.vavr.control.Option;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
class UserDataAdapter implements UserDataProvider {

    private UserCommandRepository commandRepository;
    private UserQueryRepository queryRepository;
    private UserCommandMapper commandMapper;
    private UserQueryMapper queryMapper;

    public UserDataAdapter(UserCommandRepository commandRepository, UserQueryRepository queryRepository, UserCommandMapper commandMapper, UserQueryMapper queryMapper) {
        this.commandRepository = commandRepository;
        this.queryRepository = queryRepository;
        this.commandMapper = commandMapper;
        this.queryMapper = queryMapper;
    }

    @Override
    public UserDomain save(UserDomain userDomain) {
        UserEntity userEntity = commandMapper.toEntity(userDomain);
        commandRepository.save(userEntity);
        return userDomain;
    }

    @Override
    public Option<UserDomain> findByEmail(String email) {
        return queryRepository.findByEmail(email).map(queryMapper::toDomain);
    }

    @Override
    public Page<UserDomain> findAll(Pageable pageable) {
        return queryRepository.findAll(pageable).map(queryMapper::toDomain);
    }

    @Override
    public UserDomain findById(UUID id) {
        UserEntity userEntity = queryRepository.findById(id);
        return queryMapper.toDomain(userEntity);
    }
}
