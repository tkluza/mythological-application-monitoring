package com.tkluza.smartcity.payment.business.core.domain.service.adapter

import com.tkluza.smartcity.payment.business.core.config.PaymentConfirmationProperties
import com.tkluza.smartcity.payment.business.core.domain.gateway.PaymentGateway
import com.tkluza.smartcity.payment.business.core.domain.mapper.PaymentMapper
import com.tkluza.smartcity.payment.business.core.domain.model.PaymentEntity
import com.tkluza.smartcity.payment.business.core.domain.model.PaymentStatus
import com.tkluza.smartcity.payment.business.core.domain.repository.PaymentRepository
import com.tkluza.smartcity.payment.business.core.domain.service.PaymentService
import com.tkluza.smartcity.payment.business.core.dto.command.CreatePaymentCommand
import com.tkluza.smartcity.payment.business.core.dto.event.PaymentConfirmedEvent
import com.tkluza.smartcity.payment.business.core.dto.event.PaymentRejectedEvent
import java.math.BigDecimal
import java.util.*
import kotlin.random.Random

class PaymentServiceAdapter(
    private val paymentGateway: PaymentGateway,
    private val paymentConfirmationProperties: PaymentConfirmationProperties,
    private val paymentRepository: PaymentRepository,
    private val paymentMapper: PaymentMapper
) : PaymentService {

    override fun create(command: CreatePaymentCommand) {
        val entity: PaymentEntity = paymentRepository.save(
            paymentMapper.map(
                command = command,
                status = determineStatus(),
                price = determinePrice()
            )
        )

        processResult(entity, command.reservationExternalBusinessKey)
    }

    private fun determineStatus(): PaymentStatus =
        with(paymentConfirmationProperties) {
            if (Random.nextInt(range) <= threshold) {
                PaymentStatus.CONFIRMED
            } else {
                PaymentStatus.REJECTED
            }
        }

    private fun determinePrice(): BigDecimal = BigDecimal.valueOf(Random.nextDouble(20.0))

    private fun processResult(entity: PaymentEntity, reservationExternalBusinessKey: UUID) {
        when (entity.status) {
            PaymentStatus.CONFIRMED -> paymentGateway.publishEvent(
                event = PaymentConfirmedEvent(
                    reservationExternalBusinessKey = reservationExternalBusinessKey,
                    price = entity.price
                )
            )

            else -> paymentGateway.publishEvent(event = PaymentRejectedEvent(reservationExternalBusinessKey))
        }
    }
}