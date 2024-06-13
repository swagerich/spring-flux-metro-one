package com.metro.one.services.impl;

import com.metro.one.dto.request.BankCardRequest;
import com.metro.one.dto.response.BankCardResponse;
import com.metro.one.entity.BankCard;
import com.metro.one.repository.BankCardRepository;
import com.metro.one.services.BankCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service @RequiredArgsConstructor
public class BankCardServiceImpl implements BankCardService {

    private final BankCardRepository bankCardRepository;

    @Override
    public Mono<BankCardResponse> createBankCard(Mono<BankCardRequest> bankCard) {
           Mono<BankCard> bankCardMono = BankCardRequest.toEntity(bankCard);
              return bankCardMono.flatMap(bankCardRepository::save)
                      .map(x -> BankCardResponse.builder().userId(x.getUserId()).build());
    }

}
