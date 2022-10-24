package com.tkluza.smartcity.payment.business.core.api.adapter

import com.tkluza.smartcity.payment.business.core.api.PaymentController
import com.tkluza.smartcity.payment.business.core.domain.PaymentFacade
import com.tkluza.smartcity.payment.business.core.dto.command.CreatePaymentCommand
import org.springframework.web.bind.annotation.RestController

@RestController
class PaymentControllerAdapter(
    private val paymentFacade: PaymentFacade
) : PaymentController {

    override fun createPayment(command: CreatePaymentCommand) {
        paymentFacade.createPayment(command)
    }
}