package com.project.buyit.bidding.domain.offer;

import com.project.buyit.bidding.DateUtil;
import com.project.buyit.bidding.infrastructure.input.OfferCreationDto;
import com.project.buyit.user.domain.UserDataProvider;
import com.project.buyit.user.domain.UserDomain;
import io.vavr.collection.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OfferFactory {

    private final UserDataProvider userDataProvider;

    Offer create(OfferCreationDto offerCreationDto) {
        UserDomain userDomain = userDataProvider.findById(offerCreationDto.getUserId());
        return new Offer(Offer.generate(), offerCreationDto.getTitle(), offerCreationDto.getDescription(),
                offerCreationDto.getPrice(), DateUtil.addDays(offerCreationDto.getExpirationTimeInDays()),
                userDomain, List.empty());
    }
}
