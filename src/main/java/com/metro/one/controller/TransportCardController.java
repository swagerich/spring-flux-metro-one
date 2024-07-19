package com.metro.one.controller;

import com.metro.one.controller.api.TransportCardApi;
import com.metro.one.dto.response.TransportCardResponse;
import com.metro.one.services.TransportCardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.metro.one.utils.endpoints.ApiVersion.*;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping(V1 + "transport-card")
public class TransportCardController implements TransportCardApi {


    private final TransportCardService transportCardService;

    public TransportCardController(TransportCardService transportCardService) {
        this.transportCardService = transportCardService;
    }

    @Override
    public ResponseEntity<Mono<TransportCardResponse>> fetchAllTransportCard(Long userId, Long transportCardId) {
        return ResponseEntity.ok(transportCardService.fetchTransportCardByUserIdOrTransporCardId(userId, transportCardId));
    }

}
