package com.project.buyit.bidding.infrastructure;

import com.project.buyit.bidding.domain.bid.Bid;
import com.project.buyit.bidding.domain.bid.BiddingDataProvider;
import com.project.buyit.bidding.infrastructure.mappers.BiddingMapper;
import com.project.buyit.bidding.infrastructure.repository.BidRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BidDataAdapter implements BiddingDataProvider {

    private final BidRepository bidRepository;
    private final BiddingMapper biddingMapper;

    @Override
    public Bid save(Bid bid) {
        bidRepository.save(biddingMapper.toEntity(bid));
        return bid;
    }
}
