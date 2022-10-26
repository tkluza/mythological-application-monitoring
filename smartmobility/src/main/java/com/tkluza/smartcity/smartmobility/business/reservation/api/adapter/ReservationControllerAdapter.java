package com.tkluza.smartcity.smartmobility.business.reservation.api.adapter;

import com.tkluza.smartcity.smartmobility.business.reservation.api.ReservationController;
import com.tkluza.smartcity.smartmobility.business.reservation.domain.ReservationFacade;
import com.tkluza.smartcity.smartmobility.business.reservation.dto.command.CancelReservationCommand;
import com.tkluza.smartcity.smartmobility.business.reservation.dto.command.ConfirmReservationCommand;
import com.tkluza.smartcity.smartmobility.business.reservation.dto.command.CreateReservationCommand;
import com.tkluza.smartcity.smartmobility.common.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RequiredArgsConstructor
@RestController
public class ReservationControllerAdapter implements ReservationController {

    private final ReservationFacade reservationFacade;

    @Override
    public void createReservation(@RequestBody CreateReservationCommand command) {
        try {
            reservationFacade.createReservation(command);
        } catch (BusinessException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }
    }

    @Override
    public void createRandomReservation() {
        try {
            reservationFacade.createRandomReservation();
        } catch (BusinessException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
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
