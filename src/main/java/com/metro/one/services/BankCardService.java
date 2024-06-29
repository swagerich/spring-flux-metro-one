package com.metro.one.services;

import com.metro.one.dto.request.BankCardRequest;
import com.metro.one.dto.response.BankCardResponse;
import com.metro.one.entity.BankCard;
import com.metro.one.utils.CrudMetroOne;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BankCardService extends CrudMetroOne<BankCard, Long> {

    Mono<BankCardResponse> createBankCard(Mono<BankCardRequest> bankCard, Long userId);

    Flux<BankCardResponse> fetchAllBankCardByUserId(Long userId);
}
