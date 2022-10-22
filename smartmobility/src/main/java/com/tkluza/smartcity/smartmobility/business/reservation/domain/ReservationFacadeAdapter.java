package com.tkluza.smartcity.smartmobility.business.reservation.domain;

import com.tkluza.smartcity.smartmobility.business.reservation.domain.service.ReservationService;
import com.tkluza.smartcity.smartmobility.business.reservation.dto.CancelReservationCommand;
import com.tkluza.smartcity.smartmobility.business.reservation.dto.ConfirmReservationCommand;
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
    public void confirmReservation(ConfirmReservationCommand command) {
        reservationService.change(command);
    }

    @Override
    public void cancelReservation(CancelReservationCommand command) {
        reservationService.cancel(command);
    }
}
