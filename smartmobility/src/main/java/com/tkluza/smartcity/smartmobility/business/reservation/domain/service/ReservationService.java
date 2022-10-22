package com.tkluza.smartcity.smartmobility.business.reservation.domain.service;

import com.tkluza.smartcity.smartmobility.business.reservation.dto.CancelReservationCommand;
import com.tkluza.smartcity.smartmobility.business.reservation.dto.ConfirmReservationCommand;
import com.tkluza.smartcity.smartmobility.business.reservation.dto.CreateReservationCommand;

public interface ReservationService {

    void create(CreateReservationCommand command);

    void change(ConfirmReservationCommand command);

    void cancel(CancelReservationCommand command);
}
