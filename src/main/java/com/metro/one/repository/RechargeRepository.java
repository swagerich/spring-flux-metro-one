package com.metro.one.repository;

import com.metro.one.entity.Recharge;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface RechargeRepository extends ReactiveCrudRepository<Recharge,Long> {

    Flux<Recharge> findByTransportCardId(Long transportCardId);
}
