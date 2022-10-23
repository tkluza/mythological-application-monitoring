package com.tkluza.smartcity.smartmobility.business.external.payment;

import com.tkluza.smartcity.smartmobility.business.reservation.dto.event.ReservationCreatedEvent;

/**
 * Main facade for external communication with Payment application.
 */
public interface PaymentExternalFacade {

    void processEvent(ReservationCreatedEvent event);
}
