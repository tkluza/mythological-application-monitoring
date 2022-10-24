package com.tkluza.smartcity.payment.business.api

import com.tkluza.smartcity.payment.business.dto.command.CreatePaymentCommand
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping

@RequestMapping("/payments")
interface PaymentController {

    @PostMapping(consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun createPayment(@RequestBody command: CreatePaymentCommand)
}