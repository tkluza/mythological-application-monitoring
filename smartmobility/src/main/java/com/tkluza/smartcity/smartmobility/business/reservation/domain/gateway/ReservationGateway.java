package com.tkluza.smartcity.smartmobility.business.reservation.domain.gateway;

import com.tkluza.smartcity.smartmobility.business.autonomouscar.dto.query.AutonomousCarQuery;
import com.tkluza.smartcity.smartmobility.business.reservation.dto.event.ReservationCreatedEvent;
import com.tkluza.smartcity.smartmobility.business.user.dto.query.UserQuery;

import java.util.List;

public interface ReservationGateway {

    void publishEvent(ReservationCreatedEvent event);

    List<UserQuery> findAllUsers();

    List<AutonomousCarQuery> findAllAutonomousCars();
}
