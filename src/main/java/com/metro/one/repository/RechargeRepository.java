package com.metro.one.repository;

import com.metro.one.entity.Recharge;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface RechargeRepository extends ReactiveCrudRepository<Recharge,Long> {

    Flux<Recharge> findByTransportCardId(Long transportCardId);

    Mono<Recharge> findByBankCardId(Long bankCardId);
}
