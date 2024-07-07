package com.metro.one.dto.response;

import com.metro.one.dto.RechargeDto;
import lombok.Builder;
import lombok.Data;
import reactor.core.publisher.Flux;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
public class TransportCardResponse {

    private Long userId;

    private String cardNumber;

    private BigDecimal balance;

//    private TypeRechargeOfDays typeRechargeOfDays;
//
//    private LocalDateTime issuedAtRecharge;
//
//    private BigDecimal priceRecharge;

    private List<RechargeDto> rechargeDtoFlux;

}
