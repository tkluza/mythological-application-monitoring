package com.tkluza.smartcity.payment.business.external.reservation.config

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("payment.http-client")
data class ReservationExternalProperties(
    var smartMobilityApplicationUrl: String = "",
    var networkLatencyMillis: Long = 0
)
