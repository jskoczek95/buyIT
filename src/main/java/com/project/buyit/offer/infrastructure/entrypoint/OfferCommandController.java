package com.project.buyit.offer.infrastructure.entrypoint;

import com.project.buyit.offer.infrastructure.OfferService;
import com.project.buyit.validation.ValidationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/offers")
public class OfferCommandController {

    private final OfferService offerService;

    @PostMapping
    public ResponseEntity createOffer(@RequestBody @Valid OfferCreationDto offerCreationDto) {
        return ValidationResolver.resolve(offerService.createOffer(offerCreationDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable UUID id) {
        return offerService.findById(id)
                .map(ResponseEntity::ok)
                .getOrElse(ResponseEntity.notFound().build());
    }
}
