package com.project.buyit.user.infrastructure;

import com.project.buyit.user.domain.UserDomain;
import com.project.buyit.user.domain.UserFacade;
import com.project.buyit.user.infrastructure.entrypoint.UserDetailsQuery;
import com.project.buyit.user.infrastructure.entrypoint.UserRegistrationCommand;
import com.project.buyit.validation.ResponseError;
import io.vavr.control.Either;
import io.vavr.control.Option;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserFacade userFacade;

    public Either<ResponseError, UserDomain> createUser(UserRegistrationCommand registrationCommand) {
        return userFacade.createUser(registrationCommand);
    }

    public Option<UserDetailsQuery> findById(UUID id) {
        return userFacade.findById(id);
    }

    public final Page<UserDetailsQuery> getAllUsers(Pageable pageable) {
        return userFacade.getAllUsers(pageable);
    }

}
