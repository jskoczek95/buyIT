package com.project.buyit.bidding.infrastructure.bids.entrypoint;

import com.project.buyit.bidding.domain.bids.CreateBidCommand;
import com.project.buyit.bidding.domain.bids.CreateBidCommand.Input;
import com.project.buyit.configuration.security.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/offers/{offerId}")
public class BidCommandController {

    private final CreateBidCommand command;

    @PostMapping
    public void create(@PathVariable UUID offerId, @RequestBody Input input, Authentication authentication) {
        UserPrincipal currentlyLoggedUser = (UserPrincipal) authentication.getPrincipal();
        command.execute(input, offerId, currentlyLoggedUser.getUserId());
    }
}
