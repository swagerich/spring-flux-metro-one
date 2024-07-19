package com.metro.one.repository;

import com.metro.one.entity.User;


import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface UserRepository extends ReactiveCrudRepository<User,Long> {


//    @Query("SELECT CASE WHEN COUNT(*) > 0 THEN TRUE ELSE FALSE END FROM users WHERE document_number = :documentNumber AND card_number = :cardNumber")
    Mono<Boolean>  existsByDocumentNumberOrCardNumberOrEmail(String documentNumber, Long cardNumber, String email);

//    Mono<User> findByDocumentNumberAndPassword(String documentNumber, String password);
    Mono<User> findByDocumentNumber(String documentNumber);
}
