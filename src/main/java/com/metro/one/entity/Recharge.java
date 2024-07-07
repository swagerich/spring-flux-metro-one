package com.metro.one.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.metro.one.utils.enums.TypeRechargeOfDays;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import reactor.core.publisher.Flux;

import java.math.BigDecimal;
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

    private BigDecimal amount;

    @Column("created_at")
    private LocalDateTime createAt;

    @Column("transpocard_id")
    private Long transportCardId;

    @Column("bankcard_id")
    private Long bankCardId;

    @Column("type_recharge_of_days")
    private Integer typeRechargeOfDays;

    @Transient
    private TransportCard transportCard;

    @Transient
    private BankCard bankCard;

}
