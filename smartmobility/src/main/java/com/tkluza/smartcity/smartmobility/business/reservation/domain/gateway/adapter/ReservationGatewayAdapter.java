package com.tkluza.smartcity.smartmobility.business.reservation.domain.gateway.adapter;

import com.tkluza.smartcity.smartmobility.business.autonomouscar.domain.AutonomousCarFacade;
import com.tkluza.smartcity.smartmobility.business.autonomouscar.dto.query.AutonomousCarQuery;
import com.tkluza.smartcity.smartmobility.business.reservation.domain.gateway.ReservationGateway;
import com.tkluza.smartcity.smartmobility.business.reservation.dto.event.ReservationCreatedEvent;
import com.tkluza.smartcity.smartmobility.business.user.domain.UserFacade;
import com.tkluza.smartcity.smartmobility.business.user.dto.query.UserQuery;
import org.springframework.context.ApplicationEventPublisher;

import java.util.List;

public record ReservationGatewayAdapter(
        ApplicationEventPublisher applicationEventPublisher,
        UserFacade userFacade,
        AutonomousCarFacade autonomousCarFacade
) implements ReservationGateway {

    @Override
    public void publishEvent(ReservationCreatedEvent event) {
        applicationEventPublisher.publishEvent(event);
    }

    @Override
    public List<UserQuery> findAllUsers() {
        return userFacade.findAllUsers();
    }

    @Override
    public List<AutonomousCarQuery> findAllAutonomousCars() {
        return autonomousCarFacade.findAllAutonomousCars();
    }
}
