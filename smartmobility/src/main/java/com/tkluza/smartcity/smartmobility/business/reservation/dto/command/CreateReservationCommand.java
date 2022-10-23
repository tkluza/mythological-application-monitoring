package com.tkluza.smartcity.smartmobility.business.reservation.dto.command;

public record CreateReservationCommand(
        Long userId,
        Long autonomousCarId
) {

}
