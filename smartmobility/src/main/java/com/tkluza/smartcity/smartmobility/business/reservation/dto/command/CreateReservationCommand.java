package com.tkluza.smartcity.smartmobility.business.reservation.dto.command;

import lombok.Builder;

@Builder
public record CreateReservationCommand(
        Long userId,
        Long autonomousCarId
) {

}
