package com.tkluza.smartcity.smartmobility.business.reservation.dto.command;

import java.util.UUID;

public record CancelReservationCommand(
        UUID reservationBusinessKey
) {

}
