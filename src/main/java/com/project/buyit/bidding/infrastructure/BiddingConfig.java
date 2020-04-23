package com.project.buyit.bidding.infrastructure;

import com.project.buyit.bidding.domain.bid.BidFactory;
import com.project.buyit.bidding.domain.bid.BiddingDataProvider;
import com.project.buyit.bidding.domain.bid.CreateBidCommand;
import com.project.buyit.bidding.domain.offer.CreateOfferCommand;
import com.project.buyit.bidding.domain.offer.OfferFactory;
import com.project.buyit.bidding.domain.offer.OfferingDataProvider;
import com.project.buyit.user.domain.UserDataProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BiddingConfig {

    private final OfferingDataProvider offeringDataProvider;
    private final UserDataProvider userDataProvider;
    private final BiddingDataProvider biddingDataProvider;

    @Bean
    public CreateBidCommand createBidCommand() {
        return new CreateBidCommand(bidFactory(), biddingDataProvider);
    }

    @Bean
    public BidFactory bidFactory() {
        return new BidFactory(offeringDataProvider, userDataProvider);
    }

    @Bean
    public OfferFactory offerFactory() {
        return new OfferFactory(userDataProvider);
    }

    @Bean
    public CreateOfferCommand createOfferCommand() {
        return new CreateOfferCommand(offeringDataProvider, offerFactory());
    }
}
