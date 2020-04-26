package com.project.buyit.bidding.infrastructure.offers;

import com.project.buyit.bidding.domain.offers.CreateOfferCommand;
import com.project.buyit.bidding.domain.offers.OfferDataCommandProvider;
import com.project.buyit.user.domain.UserDataProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
class OfferConfig {

    private final OfferDataCommandProvider commandProvider;
    private final UserDataProvider userDataProvider;

    @Bean
    public CreateOfferCommand createOfferCommand() {
        return new CreateOfferCommand(commandProvider, userDataProvider);
    }
}
