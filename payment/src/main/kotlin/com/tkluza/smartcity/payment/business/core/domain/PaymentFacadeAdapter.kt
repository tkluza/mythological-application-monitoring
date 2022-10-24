package com.tkluza.smartcity.payment.business.core.domain

import com.tkluza.smartcity.payment.business.core.domain.service.PaymentService
import com.tkluza.smartcity.payment.business.core.dto.command.CreatePaymentCommand
import javax.transaction.Transactional

@Transactional
open class PaymentFacadeAdapter(
    private val paymentService: PaymentService
) : PaymentFacade {

    override fun createPayment(command: CreatePaymentCommand) {
        paymentService.create(command)
    }
}