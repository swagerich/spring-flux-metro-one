package com.metro.one.dto.request;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class PaymentBankCard {

    private Long bankCardId;

    private Long transportCardId;

    private Integer typeRechargeOfDays;
}
