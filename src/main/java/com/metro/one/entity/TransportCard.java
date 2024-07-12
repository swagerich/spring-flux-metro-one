package com.metro.one.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.Id;

import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import reactor.core.publisher.Flux;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table("transport_cards")
public class TransportCard {

    @Id
    @Column("transpocard_id")
    private Long transportCardId;

    @Column("card_number")
    private Long cardNumber;

    private BigDecimal balance;

    private Long userId;

    @JsonIgnore
    @Transient
    private Flux<Recharge> recharges;


}
