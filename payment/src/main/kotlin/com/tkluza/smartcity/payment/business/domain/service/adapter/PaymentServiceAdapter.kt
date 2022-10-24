package com.tkluza.smartcity.payment.business.domain.service.adapter

import com.tkluza.smartcity.payment.business.config.PaymentConfirmationProperties
import com.tkluza.smartcity.payment.business.domain.mapper.PaymentMapper
import com.tkluza.smartcity.payment.business.domain.model.PaymentEntity
import com.tkluza.smartcity.payment.business.domain.model.PaymentStatus
import com.tkluza.smartcity.payment.business.domain.repository.PaymentRepository
import com.tkluza.smartcity.payment.business.domain.service.PaymentService
import com.tkluza.smartcity.payment.business.domain.service.gateway.PaymentGateway
import com.tkluza.smartcity.payment.business.dto.command.CreatePaymentCommand
import com.tkluza.smartcity.payment.business.dto.event.PaymentConfirmedEvent
import com.tkluza.smartcity.payment.business.dto.event.PaymentRejectedEvent
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
            paymentMapper.map(command, determineStatus())
        )

        processResult(entity, command.reservationExternalBusinessKey)
    }

    private fun processResult(entity: PaymentEntity, reservationExternalBusinessKey: UUID) {
        val paymentStatusEvent = when (entity.status) {
            PaymentStatus.CONFIRMED -> PaymentConfirmedEvent(reservationExternalBusinessKey)
            PaymentStatus.REJECTED, null -> PaymentRejectedEvent(reservationExternalBusinessKey)
        }
        paymentGateway.publishEvent(paymentStatusEvent);
    }

    private fun determineStatus(): PaymentStatus =
        if (Random(paymentConfirmationProperties.randomSeed).nextInt() >= paymentConfirmationProperties.confirmationThreshold)
            PaymentStatus.CONFIRMED
        else PaymentStatus.REJECTED
}