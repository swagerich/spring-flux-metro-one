package com.metro.one.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import reactor.core.publisher.Flux;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table("bank_cards")
public class BankCard {

    @Id
    @Column("bankcard_id")
    private Long bankCardId;

    @Column("card_number")
    private String cardNumber; //POR AHORA LO PUSE STRING PARA POBRAR PROMETEO

    @Column("expiration_date")
    private LocalDate expirationDate;

    private Integer cvv;

    @Column("user_id")
    private Long userId;

    @Transient
    @JsonIgnore
    private Flux<Recharge> recharges;
}
