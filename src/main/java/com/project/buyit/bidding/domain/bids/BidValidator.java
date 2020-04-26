package com.project.buyit.bidding.domain.bids;

import com.project.buyit.validation.ResponseError;
import io.vavr.control.Either;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class BidValidator {

    private static final Pattern priceFormat = Pattern.compile("[0-9]+([,.][0-9]{1,2})?");

    private BidValidator() {
    }

    public static Either<ResponseError, CreateBidCommand.Input> validateBid(CreateBidCommand.Input input) {
        BigDecimal price = input.getUserOffer();
        if (Objects.isNull(price) || !hasProperFormat(price)) {
            return Either.left(ResponseError.WRONG_PRICE_FORMAT);
        } else {
            return Either.right(input);
        }
    }

    private static boolean hasProperFormat(BigDecimal price) {
        Matcher matcher = priceFormat.matcher(price.toPlainString());
        return matcher.matches();
    }
}
