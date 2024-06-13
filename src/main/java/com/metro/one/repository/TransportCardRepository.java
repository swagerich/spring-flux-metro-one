package com.metro.one.repository;

import com.metro.one.entity.TransportCard;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransportCardRepository extends ReactiveCrudRepository<TransportCard,Long> {
}
