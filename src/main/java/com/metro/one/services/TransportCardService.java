package com.metro.one.services;

import com.metro.one.dto.response.TransportCardResponse;
import com.metro.one.entity.TransportCard;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public  non-sealed interface TransportCardService extends CrudMetroOne<TransportCard, Long> {

    Flux<TransportCardResponse> fechAllByUserId(Long userId,Long transportCardId);

    Mono<TransportCardResponse> fetchTransportCardByUserIdOrTransporCardId(Long userId, Long transportCardId);

    Flux<Object> fetchAllTypeOfRecharge();
}
