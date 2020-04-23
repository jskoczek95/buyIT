package com.project.buyit.bidding.infrastructure.mappers;

import com.project.buyit.bidding.domain.bid.Bid;
import com.project.buyit.bidding.domain.offer.Offer;
import com.project.buyit.bidding.infrastructure.repository.BidEntity;
import com.project.buyit.bidding.infrastructure.repository.OfferEntity;
import com.project.buyit.user.domain.UserCommandMapper;
import io.vavr.collection.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class BiddingMapper {

    private final UserCommandMapper userCommandMapper;

    public BidEntity toEntity(Bid bid) {
        return new BidEntity(bid.getId(), userCommandMapper.toEntity(bid.getUser()),
                toEntity(bid.getOffer()), bid.getPrice(), bid.getDate());
    }

    public Bid toDomain(BidEntity bidEntity) {
        return new Bid(bidEntity.getId(), userCommandMapper.toDomain(bidEntity.getUser()),
                toDomain(bidEntity.getOffer()), bidEntity.getPrice(), bidEntity.getDate());
    }

    public Offer toDomain(OfferEntity offerEntity) {
        return new Offer(offerEntity.getId(), offerEntity.getTitle(), offerEntity.getDescription(), offerEntity.getPrice(), LocalDateTime.now(),
                userCommandMapper.toDomain(offerEntity.getUser()), entityListToDomain(offerEntity.getBids()));
    }

    public OfferEntity toEntity(Offer offer) {
        return OfferEntity.builder().title(offer.getTitle())
                .description(offer.getDescription())
                .id(offer.getId())
                .price(offer.getStartingPrice())
                .user(userCommandMapper.toEntity(offer.getUser()))
                .bids(domainListToEntity(offer.getBids()))
                .build();
    }

    public List<Bid> entityListToDomain(java.util.List<BidEntity> list) {
        return List.ofAll(list.stream().map(this::toDomain));
    }

    public java.util.List<BidEntity> domainListToEntity(List<Bid> list) {
        return list.toJavaStream().map(this::toEntity).collect(Collectors.toList());
    }
}
