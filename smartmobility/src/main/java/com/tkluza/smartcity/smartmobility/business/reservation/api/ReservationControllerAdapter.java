package com.tkluza.smartcity.smartmobility.business.reservation.api;

import com.tkluza.smartcity.smartmobility.business.reservation.domain.ReservationFacade;
import com.tkluza.smartcity.smartmobility.business.reservation.dto.PlaceReservationCommand;

public record ReservationControllerAdapter(
        ReservationFacade reservationFacade
) implements ReservationController {

    @Override
    public void placeReservation(PlaceReservationCommand command) {
        reservationFacade.placeReservation(command);
    }
}
