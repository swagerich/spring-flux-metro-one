package com.metro.one.dto.response;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class BankCardAndRechargeResponse {

    private Integer typeRechargeOfDays;

    private Long cardNumber;

    private BigDecimal amount;
}
