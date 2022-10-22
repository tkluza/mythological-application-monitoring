package com.tkluza.smartcity.smartmobility.business.reservation.dto;

import java.time.LocalDateTime;

public record PlaceReservationCommand(
        Long userId,
        Long autonomousCarId,
        LocalDateTime reservationDate
) {

}
