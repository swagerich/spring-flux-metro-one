package com.metro.one.services;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public sealed interface CrudMetroOne<E, ID> permits BankCardService, RechargeService, TransportCardService, UserService {

    default Mono<E> save(E entity) {
        return null;
    }

    default Mono<E> update(E entity, ID id) {
        return null;
    }

    default Mono<E> findById(ID id) {
        return null;
    }

    default Flux<E> findAll() {
        return null;
    }

    default Mono<Void> deleteById(ID id) {
        return null;
    }
}
