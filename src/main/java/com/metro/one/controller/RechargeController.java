package com.metro.one.controller;

import com.metro.one.controller.api.RechargeApi;
import com.metro.one.dto.response.BankCardAndRechargeResponse;
import com.metro.one.services.RechargeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("recharge")
public class RechargeController implements RechargeApi {

    private final RechargeService rechargeService;

    public RechargeController(RechargeService rechargeService) {
        this.rechargeService = rechargeService;
    }

    @Override
    public ResponseEntity<Flux<Integer>> fetchAllTypeOfRecharge() {
        return ResponseEntity.ok(rechargeService.fetchAllTypeOfRecharge());
    }

    @Override
    public ResponseEntity<Mono<BankCardAndRechargeResponse>> paymentBankCardAndRecharge(Long bankCardId, Long transportCardId, Integer typeRechargeOfDays) {
        return ResponseEntity.ok(rechargeService.paymentBankCard(bankCardId,transportCardId,typeRechargeOfDays));
    }

}
