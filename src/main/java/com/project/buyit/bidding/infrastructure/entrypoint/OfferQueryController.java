package com.project.buyit.bidding.infrastructure.entrypoint;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/offers")
class OfferQueryController {

//    @GetMapping("/{id}")
//    public ResponseEntity findById(@PathVariable UUID id) {
//        return offerService.findById(id)
//                .map(ResponseEntity::ok)
//                .getOrElse(ResponseEntity.notFound().build());
//    }
}
