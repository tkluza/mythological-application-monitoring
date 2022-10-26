package com.tkluza.smartcity.payment.business.external.reservation.config

import com.tkluza.smartcity.payment.business.external.reservation.ReservationExternalFacade
import com.tkluza.smartcity.payment.business.external.reservation.ReservationExternalFacadeAdapter
import com.tkluza.smartcity.payment.business.external.reservation.http.adapter.ReservationExternalHttpClientAdapter
import com.tkluza.smartcity.payment.business.external.reservation.mapper.ReservationExternalMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient

@Configuration
class ReservationExternalConfig {

    @Bean
    fun reservationExternalFacade(reservationExternalProperties: ReservationExternalProperties): ReservationExternalFacade =
        ReservationExternalFacadeAdapter(
            reservationExternalHttpClient = ReservationExternalHttpClientAdapter(
                webClient = WebClient.create(reservationExternalProperties.smartMobilityApplicationUrl),
                mapper = ReservationExternalMapper(),
                networkLatency = reservationExternalProperties.networkLatencyMillis
            )
        )
}