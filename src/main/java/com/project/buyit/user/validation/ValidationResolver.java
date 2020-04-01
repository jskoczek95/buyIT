package com.project.buyit.user.validation;

import io.vavr.control.Either;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ValidationResolver {

    public static ResponseEntity resolve(Either<UserError, ?> data) {
        return data
                .map(ResponseEntity::ok)
                .getOrElseGet(ValidationResolver::createErrorResponse);
    }

    private static ResponseEntity createErrorResponse(UserError error) {
        int httpCode = error.getHttpCode();
        return new ResponseEntity<>(error.getMessage(), HttpStatus.valueOf(httpCode));
    }
}
