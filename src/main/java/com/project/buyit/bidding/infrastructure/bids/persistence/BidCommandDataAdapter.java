package com.project.buyit.bidding.infrastructure.bids.persistence;

import com.project.buyit.bidding.domain.bids.Bid;
import com.project.buyit.bidding.domain.bids.BidDataCommandProvider;
import com.project.buyit.bidding.infrastructure.bids.BidMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class BidCommandDataAdapter implements BidDataCommandProvider {

    private final BidCommandRepository commandRepository;
    private final BidMapper mapper;

    @Override
    public void save(Bid bid) {
        commandRepository.save(mapper.toEntity(bid));
    }
}
