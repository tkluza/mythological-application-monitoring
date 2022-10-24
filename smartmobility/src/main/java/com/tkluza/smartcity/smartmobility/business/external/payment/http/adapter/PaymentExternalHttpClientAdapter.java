package com.tkluza.smartcity.smartmobility.business.external.payment.http.adapter;

import com.tkluza.smartcity.smartmobility.business.external.payment.dto.CreatePaymentExternalCommand;
import com.tkluza.smartcity.smartmobility.business.external.payment.http.PaymentExternalHttpClient;
import com.tkluza.smartcity.smartmobility.business.external.payment.mapper.PaymentExternalMapper;
import com.tkluza.smartcity.smartmobility.business.reservation.dto.event.ReservationCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Slf4j
public record PaymentExternalHttpClientAdapter(
        WebClient webClient,
        PaymentExternalMapper paymentExternalMapper
) implements PaymentExternalHttpClient {

    private static final String PAYMENTS = "/employees";

    @Override
    public void sendRequest(ReservationCreatedEvent event) {
        CreatePaymentExternalCommand command = paymentExternalMapper.map(event);

        webClient.post()
                .uri(PAYMENTS)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(Mono.just(command), CreatePaymentExternalCommand.class)
                .retrieve()
                .bodyToMono(Void.class)
                .block();
    }
}
