package com.metro.one.services;

import com.metro.one.dto.response.BankCardAndRechargeResponse;
import com.metro.one.entity.Recharge;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public non-sealed interface RechargeService extends CrudMetroOne<Recharge, Long> {

    Flux<Integer> fetchAllTypeOfRecharge();

    Mono<BankCardAndRechargeResponse> paymentBankCard(Long bankCardId, Long transportCardId, Integer typeRechargeOfDays);

}
