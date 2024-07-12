package com.metro.one.services.impl;

import com.metro.one.dto.request.PaymentBankCard;
import com.metro.one.dto.response.BankCardAndRechargeResponse;
import com.metro.one.entity.Recharge;
import com.metro.one.exception.NotFoundException;
import com.metro.one.repository.BankCardRepository;
import com.metro.one.repository.RechargeRepository;
import com.metro.one.repository.TransportCardRepository;
import com.metro.one.services.RechargeService;
import com.metro.one.utils.enums.TypeRechargeOfDays;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RechargeServiceImpl implements RechargeService {

    private final RechargeRepository rechargeRepository;

    private final TransportCardRepository transportCardRepository;

    private final BankCardRepository bankCardRepository;

    private static final int PRICE_FOR_THIRTY_DAYS = 30;

    private static final int PRICE_FOR_TWENTY_DAYS = 20;

    private static final int PRICE_FOR_TEN_DAYS = 10;

    @Override
    public Flux<Integer> fetchAllTypeOfRecharge() {
        List<TypeRechargeOfDays> typeRechargeOfDays = Arrays.stream(TypeRechargeOfDays.values()).toList();
        return Flux.fromIterable(typeRechargeOfDays).map(TypeRechargeOfDays::getValue);
    }

    /**
     * pagar y recargar la tarjeta con la tarjeta de credito
     *
     * @param paymentCard
     * @return
     */
    @Override
    public Mono<BankCardAndRechargeResponse> paymentBankCard(Long bankCardId, Long transportCardId, Integer typeRechargeOfDays) {

        BigDecimal priceRegular = new BigDecimal("1.5");
        BigDecimal amount;
        switch (typeRechargeOfDays) {
            case 30:
                amount = priceRegular.multiply(new BigDecimal(PRICE_FOR_THIRTY_DAYS));
                break;
            case 20:
                amount = priceRegular.multiply(new BigDecimal(PRICE_FOR_TWENTY_DAYS));
                break;
            case 10:
                amount = priceRegular.multiply(new BigDecimal(PRICE_FOR_TEN_DAYS));
                break;
            default:
                return Mono.error(new IllegalArgumentException("Invalid typeRechargeOfDays"));
        }
        return transportCardRepository.findById(transportCardId)
                .switchIfEmpty(Mono.error(new NotFoundException("Not Found Recharge for this card")))
                .flatMap(recharge ->
                        bankCardRepository.findById(bankCardId)
                                .switchIfEmpty(Mono.error(new NotFoundException("Not Found Recharge for this card and bank card")))
                                .flatMap(__ -> {

                                    var newRecharge = Recharge.builder()
                                            .amount(amount)
                                            .createAt(LocalDateTime.now())
                                            .transportCardId(transportCardId)
                                            .bankCardId(bankCardId)
                                            .typeRechargeOfDays(typeRechargeOfDays)
                                            .build();

                                    return rechargeRepository.save(newRecharge)
                                            .then(transportCardRepository.findById(transportCardId))
                                            .flatMap(existingCard -> {
                                                var newBalance = existingCard.getBalance().add(amount);
                                                existingCard.setBalance(newBalance);
                                                return transportCardRepository.save(existingCard);
                                            })
                                            .flatMap(transportCard -> {
                                                var response = BankCardAndRechargeResponse.builder()
                                                        .cardNumber(transportCard.getCardNumber())
                                                        .amount(amount)
                                                        .typeRechargeOfDays(typeRechargeOfDays)
                                                        .build();
                                                return Mono.just(response);
                                            });
                                })
                );
    }
}
