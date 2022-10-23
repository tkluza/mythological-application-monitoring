package com.tkluza.smartcity.smartmobility.business.reservation.domain;

import com.tkluza.smartcity.smartmobility.business.reservation.domain.service.ReservationService;
import com.tkluza.smartcity.smartmobility.business.reservation.dto.command.CancelReservationCommand;
import com.tkluza.smartcity.smartmobility.business.reservation.dto.command.ConfirmReservationCommand;
import com.tkluza.smartcity.smartmobility.business.reservation.dto.command.CreateReservationCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@RequiredArgsConstructor
public class ReservationFacadeAdapter implements ReservationFacade {

    private final ReservationService reservationService;

    @Override
    public void createReservation(CreateReservationCommand command) {
        reservationService.create(command);
    }

    @Override
    public void confirmReservation(ConfirmReservationCommand command) {
        reservationService.confirm(command);
    }

    @Override
    public void cancelReservation(CancelReservationCommand command) {
        reservationService.cancel(command);
    }
}
