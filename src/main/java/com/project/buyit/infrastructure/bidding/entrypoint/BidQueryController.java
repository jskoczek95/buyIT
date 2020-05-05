package com.project.buyit.infrastructure.bidding.entrypoint;

import com.project.buyit.domain.bidding.GetBidsQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/offers/{offerId}")
public class BidQueryController {

    private final GetBidsQuery bidsQuery;

    @GetMapping
    public List<GetBidsQuery.Output> findAll(@PathVariable UUID offerId) {
        return bidsQuery.findAll(offerId);
    }
}
