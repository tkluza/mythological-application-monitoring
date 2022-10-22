package com.tkluza.smartcity.smartmobility.business.reservation.domain.service;

import com.tkluza.smartcity.smartmobility.business.reservation.dto.ChangeReservationCommand;
import com.tkluza.smartcity.smartmobility.business.reservation.dto.CreateReservationCommand;

public interface ReservationService {

    void create(CreateReservationCommand command);

    void change(ChangeReservationCommand command);
}
