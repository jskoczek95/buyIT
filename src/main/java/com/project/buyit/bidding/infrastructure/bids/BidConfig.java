package com.project.buyit.bidding.infrastructure.bids;

import com.project.buyit.bidding.domain.bids.BidDataCommandProvider;
import com.project.buyit.bidding.domain.bids.CreateBidCommand;
import com.project.buyit.bidding.domain.offers.OfferDataQueryProvider;
import com.project.buyit.user.domain.UserDataProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
class BidConfig {

    private final UserDataProvider userDataProvider;
    private final OfferDataQueryProvider offerDataQueryProvider;
    private final BidDataCommandProvider bidDataCommandProvider;

    @Bean
    public CreateBidCommand createBidCommand() {
        return new CreateBidCommand(userDataProvider, offerDataQueryProvider, bidDataCommandProvider);
    }
}
