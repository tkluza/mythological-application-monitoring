package com.tkluza.smartcity.smartmobility.business.external.payment.http.adapter;

import com.tkluza.smartcity.smartmobility.business.external.payment.http.PaymentExternalHttpClient;
import com.tkluza.smartcity.smartmobility.business.reservation.dto.event.ReservationCreatedEvent;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PaymentExternalHttpClientAdapter implements PaymentExternalHttpClient {

    @Override
    public void sendRequest(ReservationCreatedEvent event) {
        log.info("Event sent: {}", event);
    }
}
