package com.tkluza.smartcity.smartmobility.business.external.payment.mapper;

import com.tkluza.smartcity.smartmobility.business.external.payment.dto.SendReservationExternalCommand;
import com.tkluza.smartcity.smartmobility.business.reservation.dto.event.ReservationCreatedEvent;

import static java.util.Objects.requireNonNull;

public record PaymentExternalMapper() {

    public SendReservationExternalCommand map(ReservationCreatedEvent event) {
        requireNonNull(event);
        return SendReservationExternalCommand.builder()
                .reservationBusinessKey(event.reservationBusinessKey())
                .build();
    }
}
