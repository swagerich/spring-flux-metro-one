package com.metro.one.controller.api;

import com.metro.one.dto.response.TransportCardResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import reactor.core.publisher.Mono;

public interface TransportCardApi {

    @GetMapping
    @Operation(summary = "Get All TransportCard by userId and transportCardId", description = "We get all the transport cards by userId and transporId")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get All TransportCard successfully"),
            @ApiResponse(responseCode = "500", description = "Error internal read TransportCard")
    })
    ResponseEntity<Mono<TransportCardResponse>> fetchAllTransportCard(@RequestParam Long userId, @RequestParam Long transportCardId);
}
