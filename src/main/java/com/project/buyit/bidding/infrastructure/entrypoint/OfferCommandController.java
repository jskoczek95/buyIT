package com.project.buyit.bidding.infrastructure.entrypoint;

import com.project.buyit.bidding.domain.offer.CreateOfferCommand;
import com.project.buyit.bidding.infrastructure.input.OfferCreationDto;
import com.project.buyit.validation.ValidationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/offers")
public class OfferCommandController {

    private final CreateOfferCommand command;

    @PostMapping
    public ResponseEntity createOffer(@RequestBody @Valid OfferCreationDto offerCreationDto) {
        return ValidationResolver.resolve(command.execute(offerCreationDto));
    }
}
