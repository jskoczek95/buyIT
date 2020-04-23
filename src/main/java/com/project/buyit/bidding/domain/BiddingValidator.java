package com.project.buyit.bidding.domain;

import com.project.buyit.bidding.domain.bid.CreateBidCommand;
import com.project.buyit.bidding.infrastructure.input.OfferCreationDto;
import com.project.buyit.validation.ResponseError;
import io.vavr.collection.Stream;
import io.vavr.control.Either;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BiddingValidator {

    private static final Pattern priceFormat = Pattern.compile("[0-9]+([,.][0-9]{1,2})?");

    private BiddingValidator() {
    }

    public static Either<ResponseError, CreateBidCommand.Input> validateBid(CreateBidCommand.Input input) {
        BigDecimal price = input.getOffer();
        if (Objects.isNull(price) || !hasProperFormat(price)) {
            return Either.left(ResponseError.WRONG_PRICE_FORMAT);
        } else {
            return Either.right(input);
        }
    }

    public static Either<ResponseError, OfferCreationDto> validateOffer(OfferCreationDto offerCreationDto) {
        BigDecimal price = offerCreationDto.getPrice();
        if (Objects.isNull(price) || !hasProperFormat(price)) {
            return Either.left(ResponseError.WRONG_PRICE_FORMAT);
        }
        boolean empty = isNullOrEmpty(offerCreationDto.getDescription(), offerCreationDto.getTitle());
        return empty ? Either.left(ResponseError.EMPTY_TITLE_OR_DESCRIPTION) : Either.right(offerCreationDto);
    }

    private static boolean hasProperFormat(BigDecimal price) {
        Matcher matcher = priceFormat.matcher(price.toPlainString());
        return matcher.matches();
    }

    private static boolean isNullOrEmpty(String... input) {
        return Stream.of(input)
                .map(BiddingValidator::isNullOrEmpty)
                .fold(false, (a, b) -> a || b);
    }

    private static boolean isNullOrEmpty(String input) {
        return Objects.isNull(input) || input.isEmpty();
    }
}
