package com.metro.one.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.Id;

import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

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
    private String cardNumber;

    private BigDecimal balance;

    private Long userId;

    //private BigDecimal priceRecharge;

    //private LocalDateTime issuedAtRecharge;

    @JsonIgnore
    @Transient
    private Flux<Recharge> recharges;


}
