package com.tkluza.smartcity.smartmobility.business.reservation.domain;

import com.tkluza.smartcity.smartmobility.business.reservation.domain.service.ReservationService;
import com.tkluza.smartcity.smartmobility.business.reservation.dto.ChangeReservationCommand;
import com.tkluza.smartcity.smartmobility.business.reservation.dto.CreateReservationCommand;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ReservationFacadeAdapter implements ReservationFacade {

    private final ReservationService reservationService;

    @Override
    public void createReservation(CreateReservationCommand command) {
        reservationService.create(command);
    }

    @Override
    public void changeReservation(ChangeReservationCommand command) {
        reservationService.change(command);
    }
}
