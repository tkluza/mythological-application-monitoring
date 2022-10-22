package com.tkluza.smartcity.smartmobility.business.reservation.domain;

import com.tkluza.smartcity.smartmobility.business.reservation.dto.ChangeReservationCommand;
import com.tkluza.smartcity.smartmobility.business.reservation.dto.CreateReservationCommand;

/**
 * Entry point to Reservation domain. Includes all business process steps during reservation.
 */
public interface ReservationFacade {

    /**
     * Creates new reservation.
     *
     * @param command with required information
     */
    void createReservation(CreateReservationCommand command);

    /**
     * Changes current status of given reservation.
     *
     * @param command with required information
     */
    void changeReservation(ChangeReservationCommand command);
}
