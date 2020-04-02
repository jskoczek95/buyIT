package com.project.buyit.offer.infrastructure.entrypoint;

import com.project.buyit.offer.infrastructure.OfferCommandService;
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

    private final OfferCommandService offerCommandService;

    @PostMapping
    public ResponseEntity createOffer(@RequestBody @Valid OfferCreationDto offerCreationDto) {
        return ValidationResolver.resolve(offerCommandService.createOffer(offerCreationDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable UUID id) {
        return offerCommandService.findById(id)
                .map(ResponseEntity::ok)
                .getOrElse(ResponseEntity.notFound().build());
    }
}
