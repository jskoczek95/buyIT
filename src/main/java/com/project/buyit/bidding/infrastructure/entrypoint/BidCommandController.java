package com.project.buyit.bidding.infrastructure.entrypoint;

import com.project.buyit.bidding.domain.bid.CreateBidCommand;
import com.project.buyit.validation.ValidationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static com.project.buyit.bidding.domain.bid.CreateBidCommand.Input;

@RequiredArgsConstructor
@RestController
@RequestMapping("/{offerId}/bid")
class BidCommandController {

    private final CreateBidCommand createBidCommand;

    @PutMapping
    public ResponseEntity<Void> create(@PathVariable UUID offerId, @RequestBody Input input) {
        return ValidationResolver.resolve(createBidCommand.execute(input, offerId));
    }
}
