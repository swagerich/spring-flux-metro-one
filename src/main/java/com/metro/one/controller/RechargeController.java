package com.metro.one.controller;

import com.metro.one.dto.response.BankCardAndRechargeResponse;
import com.metro.one.services.RechargeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("recharge")
public class RechargeController {

    private final RechargeService rechargeService;

    public RechargeController(RechargeService rechargeService) {
        this.rechargeService = rechargeService;
    }

    @GetMapping
    public ResponseEntity<Flux<Integer>> fetchAllTypeOfRecharge(){
        return ResponseEntity.ok(rechargeService.fetchAllTypeOfRecharge());
    }

    @PostMapping("/payment")
    public ResponseEntity<Mono<BankCardAndRechargeResponse>> paymentBankCardAndRecharge(@RequestParam Long bankCardId, @RequestParam Long transportCardId, @RequestParam Integer typeRechargeOfDays){
        return ResponseEntity.ok(rechargeService.paymentBankCard(bankCardId,transportCardId,typeRechargeOfDays));
    }

}
