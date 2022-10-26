package com.tkluza.smartcity.smartmobility.business.reservation.api.adapter;

import com.tkluza.smartcity.smartmobility.business.reservation.api.ReservationController;
import com.tkluza.smartcity.smartmobility.business.reservation.domain.ReservationFacade;
import com.tkluza.smartcity.smartmobility.business.reservation.dto.command.CancelReservationCommand;
import com.tkluza.smartcity.smartmobility.business.reservation.dto.command.ConfirmReservationCommand;
import com.tkluza.smartcity.smartmobility.business.reservation.dto.command.CreateReservationCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ReservationControllerAdapter implements ReservationController {

    private final ReservationFacade reservationFacade;

    @Override
    public void createReservation(@RequestBody CreateReservationCommand command) {
        reservationFacade.createReservation(command);
    }

    @Override
    public void createRandomReservation() {
        reservationFacade.createRandomReservation();
    }

    @Override
    public void confirmReservation(@RequestBody ConfirmReservationCommand command) {
        reservationFacade.confirmReservation(command);
    }

    @Override
    public void cancelReservation(@RequestBody CancelReservationCommand command) {
        reservationFacade.cancelReservation(command);
    }
}
