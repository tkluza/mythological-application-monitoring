package com.tkluza.smartcity.payment.business.core.domain.service

import com.tkluza.smartcity.payment.business.core.dto.command.CreatePaymentCommand

interface PaymentService {

    fun create(command: CreatePaymentCommand)
}