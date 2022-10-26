package com.tkluza.smartcity.smartmobility.business.external.payment.http.adapter;

import com.tkluza.smartcity.smartmobility.business.external.payment.dto.CreatePaymentExternalCommand;
import com.tkluza.smartcity.smartmobility.business.external.payment.http.PaymentExternalHttpClient;
import com.tkluza.smartcity.smartmobility.business.external.payment.mapper.PaymentExternalMapper;
import com.tkluza.smartcity.smartmobility.business.reservation.dto.event.ReservationCreatedEvent;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
public record PaymentExternalHttpClientAdapter(
        WebClient webClient,
        PaymentExternalMapper paymentExternalMapper,
        Long networkLatencyMillis
) implements PaymentExternalHttpClient {

    private static final String PAYMENTS = "/payments";

    @SneakyThrows
    @Override
    public void sendRequest(ReservationCreatedEvent event) {
        CreatePaymentExternalCommand command = paymentExternalMapper.map(event);
        Thread.sleep(networkLatencyMillis);
        webClient.post()
                .uri(PAYMENTS)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .bodyValue(command)
                .retrieve()
                .bodyToMono(Void.class)
                .block();
    }
}
