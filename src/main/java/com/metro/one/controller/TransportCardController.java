package com.metro.one.controller;

import com.metro.one.dto.response.TransportCardResponse;
import com.metro.one.services.TransportCardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("transport-card")
public class TransportCardController {


    private final TransportCardService transportCardService;

    public TransportCardController(TransportCardService transportCardService) {
        this.transportCardService = transportCardService;
    }

    @GetMapping
    public ResponseEntity<Mono<TransportCardResponse>> fetchAllTransportCard(@RequestParam Long userId, @RequestParam Long transportCardId){
        return ResponseEntity.ok(transportCardService.fetchTransportCardByUserIdOrTransporCardId(userId,transportCardId));
    }

}
