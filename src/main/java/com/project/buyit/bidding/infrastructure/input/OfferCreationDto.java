package com.project.buyit.bidding.infrastructure.input;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@AllArgsConstructor
public class OfferCreationDto {

    @NotBlank
    private String title;
    @NotBlank
    private String description;
    private BigDecimal price;
    private Integer expirationTimeInDays;
    private UUID userId;
}
