package com.tkluza.smartcity.smartmobility.business.reservation.domain;

import com.tkluza.smartcity.smartmobility.business.reservation.dto.PlaceReservationCommand;

public interface ReservationFacade {

    void placeReservation(PlaceReservationCommand command);
}
