package com.tkluza.smartcity.smartmobility.business.reservation.domain.gateway.adapter;

import com.tkluza.smartcity.smartmobility.business.reservation.domain.gateway.ReservationGateway;
import com.tkluza.smartcity.smartmobility.business.reservation.dto.event.ReservationCreatedEvent;
import org.springframework.context.ApplicationEventPublisher;

public record ReservationGatewayAdapter(
        ApplicationEventPublisher applicationEventPublisher
) implements ReservationGateway {

    @Override
    public void publishEvent(ReservationCreatedEvent event) {
        applicationEventPublisher.publishEvent(event);
    }
}
