package com.project.buyit.infrastructure.bidding.persistence;

import com.project.buyit.domain.bidding.Bid;
import com.project.buyit.domain.bidding.BidDataStore;
import com.project.buyit.infrastructure.mappers.BidMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
class BidDataAdapter implements BidDataStore {

    private final BidRepository bidRepository;
    private final BidMapper mapper;


    @Override
    public SaveBidResult save(SaveBidParams bidParams) {
        BidEntity bidToSave = mapper.toEntity(bidParams);
        bidRepository.save(bidToSave);
        return new SaveBidResult(bidToSave.getId(), bidParams.getOffer(), bidParams.getUser(),
                bidToSave.getDate(), bidToSave.getUserOffer());
    }

    @Override
    public List<Bid> findByOfferId(UUID offerId) {
        return bidRepository.findAllByOfferId(offerId).stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }
}
