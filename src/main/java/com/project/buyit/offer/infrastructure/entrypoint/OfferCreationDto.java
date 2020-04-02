package com.project.buyit.offer.infrastructure.entrypoint;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class OfferCreationDto {

    @NotBlank
    private String title;
    @NotBlank
    private String description;

    private BigDecimal price;
}
