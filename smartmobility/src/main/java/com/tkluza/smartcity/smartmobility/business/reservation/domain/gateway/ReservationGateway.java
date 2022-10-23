package com.tkluza.smartcity.smartmobility.business.reservation.domain.gateway;

import com.tkluza.smartcity.smartmobility.business.reservation.dto.event.ReservationCreatedEvent;

public interface ReservationGateway {

    void publishEvent(ReservationCreatedEvent event);
}
