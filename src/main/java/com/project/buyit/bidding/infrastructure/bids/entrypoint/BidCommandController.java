package com.project.buyit.bidding.infrastructure.bids.entrypoint;

import com.project.buyit.bidding.domain.bids.CreateBidCommand;
import com.project.buyit.bidding.domain.bids.CreateBidCommand.Input;
import com.project.buyit.configuration.security.UserPrincipal;
import com.project.buyit.validation.ValidationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/offers/{offerId}")
public class BidCommandController {

    private final CreateBidCommand command;

    @PostMapping
    public ResponseEntity create(@PathVariable UUID offerId, @RequestBody Input input, Authentication authentication) {
        UserPrincipal currentlyLoggedUser = (UserPrincipal) authentication.getPrincipal();
        return ValidationResolver.resolve(command.execute(input, offerId, currentlyLoggedUser.getUserId()));
    }
}
