package com.metro.one.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BankCardResponse {

    private Long userId;

    private Long cardNumber;

    private String expirationDate;

}
