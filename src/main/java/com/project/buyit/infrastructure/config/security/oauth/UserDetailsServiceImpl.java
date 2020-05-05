package com.project.buyit.infrastructure.config.security.oauth;

import com.project.buyit.infrastructure.users.persistence.UserEntity;
import com.project.buyit.infrastructure.users.persistence.UserQueryRepository;
import io.vavr.control.Option;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserQueryRepository queryRepository;

    public UserDetails loadUserByUsername(String username) {
        Option<UserEntity> account = queryRepository.findByEmail(username);
        return new UserPrincipal(account.getOrElseThrow(() -> new UsernameNotFoundException(String.format("could not find the user with email '%s'", username))));
    }
}
