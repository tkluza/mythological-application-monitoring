package com.tkluza.smartcity.smartmobility.business.reservation.domain;

import com.tkluza.smartcity.smartmobility.business.reservation.domain.model.ReservationStatus;
import com.tkluza.smartcity.smartmobility.business.reservation.dto.CancelReservationCommand;
import com.tkluza.smartcity.smartmobility.business.reservation.dto.ConfirmReservationCommand;
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
