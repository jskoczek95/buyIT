package com.project.buyit.bidding.infrastructure.offers.entrypoint;

import com.project.buyit.bidding.domain.offers.CreateOfferCommand;
import com.project.buyit.configuration.security.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.project.buyit.bidding.domain.offers.CreateOfferCommand.Input;

@RestController
@RequiredArgsConstructor
@RequestMapping("/offers")
public class OfferCommandController {

    private final CreateOfferCommand createOfferCommand;

    @PostMapping
    public void create(@RequestBody Input input, Authentication authentication) {
        UserPrincipal currentlyLoggedUser = (UserPrincipal) authentication.getPrincipal();
        createOfferCommand.execute(input, currentlyLoggedUser.getUserId());
    }
}
