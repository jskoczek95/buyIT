package com.project.buyit.infrastructure.config;

import com.project.buyit.domain.users.CreateUserCommand;
import com.project.buyit.domain.users.GetUserQuery;
import com.project.buyit.domain.users.UserDataProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
class UserConfig {

    private final UserDataProvider userDataProvider;

    @Bean
    public CreateUserCommand createUserService() {
        return new CreateUserCommand(userDataProvider);
    }

    @Bean
    public GetUserQuery getUserQuery() {
        return new GetUserQuery(userDataProvider);
    }

}
