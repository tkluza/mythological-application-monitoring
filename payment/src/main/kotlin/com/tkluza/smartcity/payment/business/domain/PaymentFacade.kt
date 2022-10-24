package com.tkluza.smartcity.payment.business.domain

import com.tkluza.smartcity.payment.business.dto.command.CreatePaymentCommand

/**
 * Main entry point to Payment domain
 */
interface PaymentFacade {

    /**
     * Creates payment based on given [command]
     */
    fun createPayment(command: CreatePaymentCommand)
}
