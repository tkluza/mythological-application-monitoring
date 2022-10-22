package com.tkluza.smartcity.smartmobility.business.reservation.dto;

import com.tkluza.smartcity.smartmobility.business.reservation.domain.model.ReservationStatus;

import java.math.BigDecimal;
import java.util.UUID;

public record ConfirmReservationCommand(
        UUID reservationBusinessKey,
        ReservationStatus status,
        BigDecimal price
) {

}
