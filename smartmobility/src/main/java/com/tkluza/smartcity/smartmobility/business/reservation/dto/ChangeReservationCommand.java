package com.tkluza.smartcity.smartmobility.business.reservation.dto;

import com.tkluza.smartcity.smartmobility.business.reservation.domain.model.ReservationStatus;

import java.util.UUID;

public record ChangeReservationCommand(
        UUID reservationBusinessKey,
        ReservationStatus status
) {

}
