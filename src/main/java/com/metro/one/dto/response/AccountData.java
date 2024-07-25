package com.metro.one.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record AccountData(boolean valid, String message,
                          @JsonProperty("account_number") String accountNumber,
                          @JsonProperty("bank_code") String bankCode, @JsonProperty("country_code") String countryCode,
                          @JsonProperty("beneficiary_name") String beneficiaryName,
                          @JsonProperty("account_currency") String accountCurrency,
                          @JsonProperty("account_type") String accountType) {

}
