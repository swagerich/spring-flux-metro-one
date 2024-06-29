package com.metro.one.repository;

import com.metro.one.entity.BankCard;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface BankCardRepository extends ReactiveCrudRepository<BankCard,Long> {

    Flux<BankCard> findAllByUserId(Long userId);


}
