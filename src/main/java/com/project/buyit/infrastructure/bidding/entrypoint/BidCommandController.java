package com.project.buyit.infrastructure.bidding.entrypoint;

import com.project.buyit.domain.bidding.CreateBidCommand;
import com.project.buyit.domain.bidding.CreateBidCommand.Input;
import com.project.buyit.infrastructure.config.security.oauth.SecurityService;
import com.project.buyit.infrastructure.validation.ValidationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bids/{offerId}")
public class BidCommandController {

    private final CreateBidCommand command;
    private final SecurityService securityService;

    @PostMapping
    public ResponseEntity create(@PathVariable UUID offerId, @RequestBody Input input, Authentication authentication) {
        return ValidationResolver.resolveTry(securityService.getPrincipal(authentication)
                .map(user -> ValidationResolver.resolveEither(command.execute(input, offerId, user.getUserId()))));
    }
}
