package com.tkluza.smartcity.payment.business.domain

import com.tkluza.smartcity.payment.business.domain.service.PaymentService
import com.tkluza.smartcity.payment.business.dto.command.CreatePaymentCommand
import javax.transaction.Transactional

@Transactional
open class PaymentFacadeAdapter(
    private val paymentService: PaymentService
) : PaymentFacade {

    override fun createPayment(command: CreatePaymentCommand) {
        paymentService.create(command)
    }
}