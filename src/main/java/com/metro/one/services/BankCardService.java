package com.metro.one.services;

import com.metro.one.dto.request.AccountBankRequest;
import com.metro.one.dto.request.BankCardRequest;
import com.metro.one.dto.response.AccountBankResponse;
import com.metro.one.dto.response.BankCardResponse;
import com.metro.one.entity.BankCard;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public non-sealed interface BankCardService extends CrudMetroOne<BankCard, Long> {

    Mono<BankCardResponse> createBankCard(Mono<BankCardRequest> bankCard, Long userId);

    Flux<BankCardResponse> fetchAllBankCardByUserId(Long userId);

    Mono<AccountBankResponse> createMockBankCard(AccountBankRequest account, Long userId);
}
