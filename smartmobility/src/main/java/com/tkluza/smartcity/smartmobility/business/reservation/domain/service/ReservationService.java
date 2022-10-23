package com.tkluza.smartcity.smartmobility.business.reservation.domain.service;

import com.tkluza.smartcity.smartmobility.business.reservation.dto.command.CancelReservationCommand;
import com.tkluza.smartcity.smartmobility.business.reservation.dto.command.ConfirmReservationCommand;
import com.tkluza.smartcity.smartmobility.business.reservation.dto.command.CreateReservationCommand;

public interface ReservationService {

    void create(CreateReservationCommand command);

    void confirm(ConfirmReservationCommand command);

    void cancel(CancelReservationCommand command);
}
