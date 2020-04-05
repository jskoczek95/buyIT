package com.project.buyit.user.infrastructure;

import com.project.buyit.user.domain.UserCommandMapper;
import com.project.buyit.user.domain.UserDataProvider;
import com.project.buyit.user.domain.UserFacade;
import com.project.buyit.user.domain.UserQueryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.project.buyit.configuration.security.OAuth2Config.passwordEncoder;

@Configuration
@RequiredArgsConstructor
class UserConfig {

    private final UserDataProvider userDataProvider;
    private final UserQueryMapper userQueryMapper;
    private final UserCommandMapper userCommandMapper;

    @Bean
    public UserFacade userFacade() {
        return new UserFacade(userDataProvider, userQueryMapper, userCommandMapper, passwordEncoder());
    }

}
