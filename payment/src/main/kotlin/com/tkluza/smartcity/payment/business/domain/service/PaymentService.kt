package com.tkluza.smartcity.payment.business.domain.service

import com.tkluza.smartcity.payment.business.dto.command.CreatePaymentCommand

interface PaymentService {

    fun create(command: CreatePaymentCommand)
}