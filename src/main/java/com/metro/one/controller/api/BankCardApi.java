package com.metro.one.controller.api;

import com.metro.one.dto.request.BankCardRequest;
import com.metro.one.dto.response.BankCardResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BankCardApi {

    @PostMapping(value = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Create a new Bank Card", description = "Create a new Bank Card")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Bank Card registered successfully"),
            @ApiResponse(responseCode = "400", description = "Bad request Error create bank card")
    })
    ResponseEntity<Mono<BankCardResponse>> createBankCard(@RequestBody Mono<BankCardRequest> bankCard, @PathVariable Long userId);


    @GetMapping(value = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get All BankCard By userId", description = "We read all cards by user id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "read card successfully"),
            @ApiResponse(responseCode = "400", description = "Bad request Error read card")
    })
    ResponseEntity<Flux<BankCardResponse>> fetchAllBankCardByUserId(@PathVariable Long userId);


    @DeleteMapping(value = "/{bankCardId}")
    @Operation(summary = "Delete BankCard Id", description = "We eliminate the bank card by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Delete bankCardId successfully"),
            @ApiResponse(responseCode = "400", description = "Bad request Error Delete bankCardId")
    })
    ResponseEntity<Mono<Void>> deleteByBankCardId(@PathVariable Long bankCardId);
}
