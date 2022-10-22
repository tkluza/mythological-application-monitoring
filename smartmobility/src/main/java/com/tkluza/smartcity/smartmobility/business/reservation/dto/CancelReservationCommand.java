package com.tkluza.smartcity.smartmobility.business.reservation.dto;

import java.util.UUID;

public record CancelReservationCommand(
        UUID reservationBusinessKey
) {

}
