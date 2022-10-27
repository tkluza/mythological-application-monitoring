package com.tkluza.smartcity.smartmobility.business.reservation.config;

import com.tkluza.smartcity.smartmobility.business.autonomouscar.domain.AutonomousCarFacade;
import com.tkluza.smartcity.smartmobility.business.reservation.domain.ReservationFacade;
import com.tkluza.smartcity.smartmobility.business.reservation.domain.ReservationFacadeAdapter;
import com.tkluza.smartcity.smartmobility.business.reservation.domain.gateway.ReservationGateway;
import com.tkluza.smartcity.smartmobility.business.reservation.domain.gateway.adapter.ReservationGatewayAdapter;
import com.tkluza.smartcity.smartmobility.business.reservation.domain.repository.ReservationRepository;
import com.tkluza.smartcity.smartmobility.business.reservation.domain.service.ReservationService;
import com.tkluza.smartcity.smartmobility.business.reservation.domain.service.adapter.ReservationServiceAdapter;
import com.tkluza.smartcity.smartmobility.business.user.domain.UserFacade;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReservationConfig {

    @Bean
    public ReservationFacade reservationFacade(MeterRegistry meterRegistry,
                                               ApplicationEventPublisher applicationEventPublisher,
                                               UserFacade userFacade,
                                               AutonomousCarFacade autonomousCarFacade,
                                               ReservationRepository reservationRepository) {
        ReservationGateway reservationGateway = new ReservationGatewayAdapter(
                applicationEventPublisher,
                userFacade,
                autonomousCarFacade
        );
        ReservationService reservationService = new ReservationServiceAdapter(
                meterRegistry,
                reservationGateway,
                reservationRepository
        );

        return new ReservationFacadeAdapter(reservationService);
    }
}
