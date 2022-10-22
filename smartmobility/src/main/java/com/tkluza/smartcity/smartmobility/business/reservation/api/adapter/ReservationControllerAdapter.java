package com.tkluza.smartcity.smartmobility.business.reservation.api.adapter;

import com.tkluza.smartcity.smartmobility.business.reservation.api.ReservationController;
import com.tkluza.smartcity.smartmobility.business.reservation.domain.ReservationFacade;
import com.tkluza.smartcity.smartmobility.business.reservation.dto.ChangeReservationCommand;
import com.tkluza.smartcity.smartmobility.business.reservation.dto.CreateReservationCommand;
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
    public void changeReservation(@RequestBody ChangeReservationCommand command) {
        reservationFacade.changeReservation(command);
    }
}
