package com.metro.one.services.impl;

import com.metro.one.dto.request.BankCardRequest;
import com.metro.one.dto.response.BankCardResponse;
import com.metro.one.exception.NotFoundException;
import com.metro.one.repository.BankCardRepository;
import com.metro.one.repository.UserRepository;
import com.metro.one.services.BankCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.metro.one.utils.dates.Dates.toFormatToYearMonth;

@Service
@RequiredArgsConstructor
public class BankCardServiceImpl implements BankCardService {

    private final BankCardRepository bankCardRepository;

    private final UserRepository userRepository;

    /**
     * AQUI DERIA DE CARGAR UNA API DE LA TARJETA (POR AHORA SE GUARDARA DINAMICAMENTE EN LA BD)
     *
     * @param bankCard
     * @return
     */
    @Override
    public Mono<BankCardResponse> createBankCard(Mono<BankCardRequest> bankCard, Long userId) {

        return userRepository.findById(userId).switchIfEmpty(Mono.error(new NotFoundException("User "+ userId +" not found"))).flatMap(user ->
                 BankCardRequest.toEntity(bankCard).flatMap(bank -> {
                     bank.setUserId(user.getUserId());
                    return bankCardRepository.save(bank).map(__ -> BankCardResponse.builder().userId(bank.getUserId()).build());
                }));
    }

    /**
     * Fetch all bank card by user id
     *
     * @param userId
     * @return
     */
    @Override
    public Flux<BankCardResponse> fetchAllBankCardByUserId(Long userId) {
        return bankCardRepository.findAllByUserId(userId).switchIfEmpty(Mono.error(new NotFoundException("User "+ userId +"Not Found"))).map(
                b -> BankCardResponse.builder().cardNumber(b.getCardNumber()).expirationDate(toFormatToYearMonth(b.getExpirationDate().toString())).build()
        );
    }


    /**
     * Delete bank card by id
     * @param bankCardId
     * @return
     */
    @Override
    public Mono<Void> deleteById(Long bankCardId) {
        return bankCardRepository.findById(bankCardId)
                .switchIfEmpty(Mono.error(new NotFoundException("BankCard id : " + bankCardId + " Not found")))
                .flatMap(bankCardRepository::delete);
    }
}
