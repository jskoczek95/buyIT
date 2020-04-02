package com.project.buyit.offer.infrastructure;

import com.project.buyit.offer.domain.OfferDataProvider;
import com.project.buyit.offer.domain.OfferFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class OfferConfig {

    private final OfferDataProvider offerDataProvider;

    @Bean
    public OfferFacade offerFacade() {
        return new OfferFacade(offerDataProvider);
    }
}
