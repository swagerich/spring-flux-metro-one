package com.metro.one.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table("recharges")
public class Recharge {

    @Id
    @Column("recharge_id")
    private Long rechargeId;

    private Double amount;

    @Column("create_at")
    private LocalDateTime createAt;

    private Long transportCardId;

    private Long bankCardId;

    @Transient
    private TransportCard transportCard;
    @Transient
    private BankCard bankCard;

}
