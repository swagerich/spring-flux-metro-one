package com.metro.one.dto;

import com.metro.one.utils.enums.TypeRechargeOfDays;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class RechargeDto {

    private TypeRechargeOfDays typeRechargeOfDays;

    private LocalDateTime issuedAtRecharge;

    private BigDecimal priceRecharge;


}
