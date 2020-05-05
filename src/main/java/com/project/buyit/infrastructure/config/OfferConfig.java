package com.project.buyit.infrastructure.config;

import com.project.buyit.domain.offers.CreateOfferCommand;
import com.project.buyit.domain.offers.OfferDataCommandProvider;
import com.project.buyit.domain.users.UserDataProvider;
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
