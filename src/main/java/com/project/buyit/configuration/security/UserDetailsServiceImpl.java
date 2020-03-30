package com.project.buyit.configuration.security;

import com.project.buyit.user.User;
import com.project.buyit.user.UserRepository;
import io.vavr.control.Option;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetails loadUserByUsername(String username) {
        Option<User> account = userRepository.findByEmail(username);
        return new UserPrincipal(account.getOrElseThrow(() -> new UsernameNotFoundException(String.format("could not find the user with email '%s'", username))));
    }
}
