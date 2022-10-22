package com.tkluza.smartcity.smartmobility.business.reservation.config;

import com.tkluza.smartcity.smartmobility.business.reservation.domain.ReservationFacade;
import com.tkluza.smartcity.smartmobility.business.reservation.domain.ReservationFacadeAdapter;
import com.tkluza.smartcity.smartmobility.business.reservation.domain.repository.ReservationRepository;
import com.tkluza.smartcity.smartmobility.business.reservation.domain.service.ReservationService;
import com.tkluza.smartcity.smartmobility.business.reservation.domain.service.adapter.ReservationServiceAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReservationConfig {

    @Bean
    public ReservationFacade reservationFacade(ReservationRepository reservationRepository) {
        ReservationService reservationService = new ReservationServiceAdapter(
                reservationRepository
        );

        return new ReservationFacadeAdapter(reservationService);
    }
}
