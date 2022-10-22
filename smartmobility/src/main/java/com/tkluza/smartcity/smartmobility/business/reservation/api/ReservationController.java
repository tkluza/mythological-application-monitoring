package com.tkluza.smartcity.smartmobility.business.reservation.api;

import com.tkluza.smartcity.smartmobility.business.reservation.dto.PlaceReservationCommand;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/reservations")
public interface ReservationController {

    void placeReservation(PlaceReservationCommand command);
}
