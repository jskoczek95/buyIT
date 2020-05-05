package com.project.buyit.infrastructure.offers.entrypoint;

import com.project.buyit.domain.offers.CreateOfferCommand;
import com.project.buyit.infrastructure.config.security.oauth.UserPrincipal;
import com.project.buyit.infrastructure.validation.ValidationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.project.buyit.domain.offers.CreateOfferCommand.Input;

@RestController
@RequiredArgsConstructor
@RequestMapping("/offers")
public class OfferCommandController {

    private final CreateOfferCommand createOfferCommand;

    @PostMapping
    public ResponseEntity create(@RequestBody Input input, Authentication authentication) {
        UserPrincipal currentlyLoggedUser = (UserPrincipal) authentication.getPrincipal();
        return ValidationResolver.resolveEither(createOfferCommand.execute(input, currentlyLoggedUser.getUserId()));
    }
}
