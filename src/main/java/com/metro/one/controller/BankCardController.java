package com.metro.one.controller;

import com.metro.one.dto.request.BankCardRequest;
import com.metro.one.dto.response.BankCardResponse;
import com.metro.one.services.BankCardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/bank-card")
public class BankCardController {

    private final BankCardService bankCardService;

    public BankCardController(BankCardService bankCardService) {
        this.bankCardService = bankCardService;
    }

    @PostMapping
    public ResponseEntity<Mono<BankCardResponse>> createBankCard(@RequestBody  Mono<BankCardRequest> bankCard){
        return new ResponseEntity<>(bankCardService.createBankCard(bankCard), HttpStatus.CREATED);
    }
}
