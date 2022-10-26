package com.tkluza.smartcity.smartmobility.business.reservation.domain;

import com.tkluza.smartcity.smartmobility.business.reservation.domain.model.ReservationStatus;
import com.tkluza.smartcity.smartmobility.business.reservation.dto.command.CancelReservationCommand;
import com.tkluza.smartcity.smartmobility.business.reservation.dto.command.ConfirmReservationCommand;
import com.tkluza.smartcity.smartmobility.business.reservation.dto.command.CreateReservationCommand;

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
     * Creates new reservation based on random information about existing user and autonomous car.
     */
    void createRandomReservation();

    /**
     * Confirms given reservation.
     * <p>
     * It changes status to {@link ReservationStatus#CONFIRMED}
     *
     * @param command with required information
     */
    void confirmReservation(ConfirmReservationCommand command);

    /**
     * Cancels given reservation.
     * <p>
     * It changes status to {@link ReservationStatus#CANCELLED}
     *
     * @param command with required information
     */
    void cancelReservation(CancelReservationCommand command);
}
