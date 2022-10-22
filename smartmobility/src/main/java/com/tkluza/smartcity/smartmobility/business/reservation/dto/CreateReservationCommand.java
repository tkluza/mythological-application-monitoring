package com.tkluza.smartcity.smartmobility.business.reservation.dto;

public record CreateReservationCommand(
        Long userId,
        Long autonomousCarId
) {

}
