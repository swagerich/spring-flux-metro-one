package com.metro.one.controller;

import com.metro.one.controller.api.BankCardApi;
import com.metro.one.dto.request.BankCardRequest;
import com.metro.one.dto.response.BankCardResponse;
import com.metro.one.services.BankCardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static com.metro.one.utils.endpoints.ApiVersion.*;

import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(V1 + "bank-card")
public class BankCardController implements BankCardApi {

    private final BankCardService bankCardService;

    public BankCardController(BankCardService bankCardService) {
        this.bankCardService = bankCardService;
    }

    @Override
    public ResponseEntity<Mono<BankCardResponse>> createBankCard(Mono<BankCardRequest> bankCard, Long userId) {
        return new ResponseEntity<>(bankCardService.createBankCard(bankCard, userId), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Flux<BankCardResponse>> fetchAllBankCardByUserId(Long userId) {
        return new ResponseEntity<>(bankCardService.fetchAllBankCardByUserId(userId), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Mono<Void>> deleteByBankCardId(Long bankCardId) {
        return new ResponseEntity<>(bankCardService.deleteById(bankCardId), HttpStatus.OK);
    }
}
