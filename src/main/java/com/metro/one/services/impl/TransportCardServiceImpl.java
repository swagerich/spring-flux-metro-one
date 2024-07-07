package com.metro.one.services.impl;

import com.metro.one.dto.RechargeDto;
import com.metro.one.dto.response.TransportCardResponse;
import com.metro.one.repository.RechargeRepository;
import com.metro.one.repository.TransportCardRepository;
import com.metro.one.services.TransportCardService;
import com.metro.one.utils.enums.TypeRechargeOfDays;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransportCardServiceImpl implements TransportCardService {

    private final TransportCardRepository transportCardRepository;

    private final RechargeRepository rechargeRepository;



    @Override
    public Flux<TransportCardResponse> fechAllByUserId(Long userId, Long transportCardId) {
        return null;
                    /*TypeRechargeOfDays typeRechargeOfDays = x.getTypeRechargeOfDays();
                    switch (typeRechargeOfDays){
                        case THIRTY_DAYS:
                            return Mono.just();
                        case TWENTY_DAYS:
                            return Mono.just(x.getAmount());
                        case TEN_DAYS:
                            return Mono.just(x.getAmount());
                        default:
                            return Flux.empty();
                    }*/

    }

    /**
     * POR AHORA TRAEMOS DE MANERA DINAMICA LA LECTURA DE LA TARJETA POR LA BD
     *
     * @param userId
     * @param transportCardId
     * @return
     */
    @Override
    public Mono<TransportCardResponse> fetchTransportCardByUserIdOrTransporCardId(Long userId, Long transportCardId) {
       return  transportCardRepository.findByUserId(userId).switchIfEmpty(Mono.error(new RuntimeException("userId not Found")))
                .flatMap(transportCard -> rechargeRepository.findByTransportCardId(transportCardId).switchIfEmpty(Mono.error(new RuntimeException("transportCardId not Found")))
                        .map(recharge -> RechargeDto.builder()
                                .typeRechargeOfDays(TypeRechargeOfDays.fromValue(recharge.getTypeRechargeOfDays()))
                                .issuedAtRecharge(recharge.getCreateAt())
                                .priceRecharge(recharge.getAmount())
                                .build())
                        .collectList()
                        .map(transportCardDtos -> TransportCardResponse.builder()
                                .userId(userId)
                                .cardNumber(transportCard.getCardNumber())
                                .balance(transportCard.getBalance())
                                .rechargeDtoFlux(transportCardDtos)
                                .build()));

    }

    @Override
    public Flux<Object> fetchAllTypeOfRecharge() {
        List<TypeRechargeOfDays> list = Arrays.stream(TypeRechargeOfDays.values()).toList();
        Flux<TypeRechargeOfDays> typeRechargeOfDaysFlux = Flux.fromIterable(list);

        return null;
    }
}
