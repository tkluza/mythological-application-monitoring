package com.tkluza.smartcity.smartmobility.business.external.payment.mapper;

import com.tkluza.smartcity.smartmobility.business.external.payment.dto.CreatePaymentExternalCommand;
import com.tkluza.smartcity.smartmobility.business.reservation.dto.event.ReservationCreatedEvent;

import static java.util.Objects.requireNonNull;

public record PaymentExternalMapper() {

    public CreatePaymentExternalCommand map(ReservationCreatedEvent event) {
        requireNonNull(event);
        return CreatePaymentExternalCommand.builder()
                .reservationExternalBusinessKey(event.reservationBusinessKey())
                .build();
    }
}
