package com.project.buyit.bidding.domain.bid;

import com.project.buyit.bidding.domain.BiddingValidator;
import com.project.buyit.validation.ResponseError;
import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
public class CreateBidCommand {

    private final BidFactory bidFactory;
    private final BiddingDataProvider biddingDataProvider;

    public Either<ResponseError, Bid> execute(Input input, UUID offerId) {
        return BiddingValidator.validateBid(input)
                .map(myInput -> bidFactory.create(myInput, offerId))
                .map(biddingDataProvider::save);
    }

    @Value
    public static class Input {
        UUID userId;
        BigDecimal offer;
        LocalDateTime date;
    }
}
