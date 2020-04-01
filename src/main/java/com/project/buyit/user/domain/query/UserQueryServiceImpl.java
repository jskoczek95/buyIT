package com.project.buyit.user.domain.query;

import io.vavr.control.Option;
import io.vavr.control.Try;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
class UserQueryServiceImpl implements UserQueryService {

    private final UserQueryMapper queryMapper;
    private final UserQueryRepository userRepository;

    @Override
    public Page<UserDetailsQuery> getAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable).map(queryMapper::toDetailsQuery);
    }

    @Override
    public Option<UserDetailsQuery> findById(UUID id) {
        return Try.ofSupplier(() -> Option.of(userRepository.findById(id))).getOrElse(Option.none())
                .map(queryMapper::toDetailsQuery);
    }
}
