package com.metro.one.controller.api;

import com.metro.one.dto.response.BankCardAndRechargeResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface RechargeApi {

    @GetMapping
    @Operation(summary = "Get All recharge", description = "We read all recharges")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Read recharge successfully"),
            @ApiResponse(responseCode = "500", description = "Error internal read recharge")
    })
    ResponseEntity<Flux<Integer>> fetchAllTypeOfRecharge();

    @PostMapping("/payment")
    @Operation(summary = "Register paymentcard And recharge", description = "registration of card payments and recharge")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Register recharge successfully"),
            @ApiResponse(responseCode = "500", description = "Error internal register recharge")
    })
    ResponseEntity<Mono<BankCardAndRechargeResponse>> paymentBankCardAndRecharge(@RequestParam Long bankCardId, @RequestParam Long transportCardId, @RequestParam Integer typeRechargeOfDays);
}
