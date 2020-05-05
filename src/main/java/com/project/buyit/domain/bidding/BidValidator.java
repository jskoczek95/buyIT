package com.project.buyit.domain.bidding;

import com.project.buyit.domain.bidding.BidDataStore.SaveBidParams;
import com.project.buyit.domain.errors.ResponseError;
import io.vavr.control.Either;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class BidValidator {

    private static final Pattern priceFormat = Pattern.compile("[0-9]+([,.][0-9]{1,2})?");

    private BidValidator() {
    }

    public static Either<ResponseError, SaveBidParams> validateBid(SaveBidParams input) {
        BigDecimal price = input.getUserOffer();
        return Objects.isNull(price) || !hasProperFormat(price) ? Either.left(ResponseError.WRONG_PRICE_FORMAT) : Either.right(input);
    }

    private static boolean hasProperFormat(BigDecimal price) {
        Matcher matcher = priceFormat.matcher(price.toPlainString());
        return matcher.matches();
    }
}
