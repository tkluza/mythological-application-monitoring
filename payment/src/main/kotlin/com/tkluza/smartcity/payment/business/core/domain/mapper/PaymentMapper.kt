package com.tkluza.smartcity.payment.business.core.domain.mapper

import com.tkluza.smartcity.payment.business.core.domain.model.PaymentEntity
import com.tkluza.smartcity.payment.business.core.domain.model.PaymentStatus
import com.tkluza.smartcity.payment.business.core.dto.command.CreatePaymentCommand
import java.math.BigDecimal
import java.time.LocalDateTime

class PaymentMapper {

    fun map(command: CreatePaymentCommand, status: PaymentStatus, price: BigDecimal): PaymentEntity =
        with(command) {
            PaymentEntity(
                reservationExternalBusinessKey = reservationExternalBusinessKey,
                date = LocalDateTime.now(),
                status = status,
                price = price
            )
        }
}