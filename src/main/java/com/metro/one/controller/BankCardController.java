package com.metro.one.controller;

import com.metro.one.dto.request.BankCardRequest;
import com.metro.one.dto.response.BankCardResponse;
import com.metro.one.services.BankCardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/bank-card")
public class BankCardController {

    private final BankCardService bankCardService;

    public BankCardController(BankCardService bankCardService) {
        this.bankCardService = bankCardService;
    }

    @PostMapping("/{userId}")
    public ResponseEntity<Mono<BankCardResponse>> createBankCard(@RequestBody  Mono<BankCardRequest> bankCard, @PathVariable Long userId){
        return new ResponseEntity<>(bankCardService.createBankCard(bankCard,userId), HttpStatus.CREATED);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Flux<BankCardResponse>> fetchAllBankCardByUserId(@PathVariable Long userId){
        return new ResponseEntity<>(bankCardService.fetchAllBankCardByUserId(userId), HttpStatus.OK);
    }

    @DeleteMapping("/{bankCardId}")
    public ResponseEntity<Mono<Void>> deleteByBankCardId(@PathVariable Long bankCardId){
        return new ResponseEntity<>(bankCardService.deleteById(bankCardId), HttpStatus.OK);
    }
}
