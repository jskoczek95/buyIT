package com.project.buyit.infrastructure.config.security.oauth;

import io.vavr.control.Try;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class SecurityService {

    public Try<UserPrincipal> getPrincipal(Authentication authentication) {
        return Try.ofSupplier(authentication::getPrincipal)
                .map(principal -> (UserPrincipal) principal);
    }
}
