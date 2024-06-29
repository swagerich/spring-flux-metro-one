package com.metro.one.dto.request;

import com.metro.one.entity.BankCard;
import lombok.Builder;
import lombok.Data;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@Data
public class BankCardRequest {

    private Long cardNumber;

    private LocalDate expirationDate;

    private Integer cvv;

    private Long userId;


    public static Mono<BankCard> toEntity(Mono<BankCardRequest> bankCardRequest){
            return bankCardRequest.switchIfEmpty(Mono.error(new RuntimeException("BanCard is null")))
                    .map(request -> BankCard.builder()
                            .cardNumber(request.getCardNumber())
                            .expirationDate(request.getExpirationDate())
                            .cvv(request.getCvv())
                            .userId(request.getUserId())
                            .build());
    }

}
