package com.tkluza.smartcity.smartmobility.business.reservation.dto.command;

import java.math.BigDecimal;
import java.util.UUID;

public record ConfirmReservationCommand(
        UUID reservationBusinessKey,
        BigDecimal price
) {

}
