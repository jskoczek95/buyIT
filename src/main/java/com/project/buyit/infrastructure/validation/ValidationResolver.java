package com.project.buyit.infrastructure.validation;

import com.project.buyit.domain.errors.ResponseError;
import com.project.buyit.domain.errors.UserNotFoundException;
import io.vavr.control.Either;
import io.vavr.control.Try;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ValidationResolver {

    public static ResponseEntity resolveEither(Either<ResponseError, ?> data) {
        return data
                .map(ResponseEntity::ok)
                .getOrElseGet(ValidationResolver::createErrorResponse);
    }

    private static ResponseEntity createErrorResponse(ResponseError error) {
        int httpCode = error.getHttpCode();
        return new ResponseEntity<>(error.getMessage(), HttpStatus.valueOf(httpCode));
    }

    public static ResponseEntity resolveTry(Try<?> tryObject) {
        return tryObject
                .map(ResponseEntity::ok)
                .getOrElseThrow(UserNotFoundException::new);
    }
}
