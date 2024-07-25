package com.metro.one.proxy;

import com.metro.one.dto.response.AccountBankResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class AccountBankProxy {

    private final WebClient webClient;

    @Value("${prometeo.api_key}")
    private String API_KEY;

    @Value("${prometeo.end_point}")
    private String END_POINT;

    public Mono<AccountBankResponse> consumePrometeoApi(String request) {
        return webClient.post()
                .uri(END_POINT)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .accept(MediaType.APPLICATION_JSON)
                .header("X-API-Key", API_KEY)
                .bodyValue(request)
                .retrieve()
                .bodyToMono(AccountBankResponse.class);
    }

}
