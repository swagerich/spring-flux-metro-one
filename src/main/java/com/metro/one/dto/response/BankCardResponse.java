package com.metro.one.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BankCardResponse {

    private Long userId;

    private String cardNumber; //POR AHORA LO PUSE STRING PARA PROBAR PROMETEO

    private String expirationDate;

}
