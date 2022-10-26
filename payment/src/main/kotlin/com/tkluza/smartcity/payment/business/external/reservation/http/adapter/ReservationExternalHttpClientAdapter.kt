package com.tkluza.smartcity.payment.business.external.reservation.http.adapter

import com.tkluza.smartcity.payment.business.core.dto.event.PaymentConfirmedEvent
import com.tkluza.smartcity.payment.business.core.dto.event.PaymentRejectedEvent
import com.tkluza.smartcity.payment.business.external.reservation.http.ReservationExternalHttpClient
import com.tkluza.smartcity.payment.business.external.reservation.mapper.ReservationExternalMapper
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.client.WebClient

class ReservationExternalHttpClientAdapter(
    private val webClient: WebClient,
    private val mapper: ReservationExternalMapper,
    private val networkLatency: Long,

    ) : ReservationExternalHttpClient {

    override fun sendRequest(event: PaymentConfirmedEvent) {
        Thread.sleep(networkLatency);
        webClient.put()
            .uri(RESERVATIONS)
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .bodyValue(mapper.map(event))
            .retrieve()
            .bodyToMono(Void::class.java)
            .block()
    }

    override fun sendRequest(event: PaymentRejectedEvent) {
        Thread.sleep(networkLatency);
        webClient
            .method(HttpMethod.DELETE)
            .uri(RESERVATIONS)
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .bodyValue(mapper.map(event))
            .retrieve()
            .bodyToMono(Void::class.java)
            .block()
    }

    companion object {
        const val RESERVATIONS: String = "/reservations"
    }
}