package com.metro.one.dto.request;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AccountBankRequest {

//    private String countryCode;

    private String accountNumber;

//    private String bankCode;

    private Integer cvv;

    private LocalDate expirationDate;
}
