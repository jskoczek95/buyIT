package com.project.buyit.infrastructure.config;

import com.project.buyit.domain.bidding.BidDataStore;
import com.project.buyit.domain.bidding.CreateBidCommand;
import com.project.buyit.domain.bidding.GetBidsQuery;
import com.project.buyit.domain.offers.OfferDataQueryProvider;
import com.project.buyit.domain.users.UserDataProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
class BidConfig {

    private final UserDataProvider userDataProvider;
    private final OfferDataQueryProvider offerDataQueryProvider;
    private final BidDataStore dataStore;

    @Bean
    public CreateBidCommand createBidCommand() {
        return new CreateBidCommand(userDataProvider, offerDataQueryProvider, dataStore);
    }

    @Bean
    public GetBidsQuery getBidsQuery() {
        return new GetBidsQuery(dataStore);
    }
}
