package com.project.buyit.user.infrastructure;

import com.project.buyit.user.domain.UserDataProvider;
import com.project.buyit.user.domain.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.project.buyit.configuration.security.OAuth2Config.passwordEncoder;

@Configuration
@RequiredArgsConstructor
class UserConfig {

    private final UserDataProvider userDataProvider;
    private final UserMapper userMapper;

    @Bean
    public UserFacade userFacade() {
        return new UserFacade(userDataProvider, userMapper, passwordEncoder());
    }

}
