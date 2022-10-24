package com.tkluza.smartcity.payment.business.api.adapter

import com.tkluza.smartcity.payment.business.api.PaymentController
import com.tkluza.smartcity.payment.business.domain.PaymentFacade
import com.tkluza.smartcity.payment.business.dto.command.CreatePaymentCommand
import org.springframework.web.bind.annotation.RestController

@RestController
class PaymentControllerAdapter(
    private val paymentFacade: PaymentFacade
) : PaymentController {

    override fun createPayment(command: CreatePaymentCommand) {
        paymentFacade.createPayment(command)
    }
}