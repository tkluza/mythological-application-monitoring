package com.tkluza.smartcity.smartmobility.business.external.payment.http;

import com.tkluza.smartcity.smartmobility.business.reservation.dto.event.ReservationCreatedEvent;

public interface PaymentExternalHttpClient {

    void sendRequest(ReservationCreatedEvent event);
}
