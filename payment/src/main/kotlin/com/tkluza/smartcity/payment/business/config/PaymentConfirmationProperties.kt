package com.tkluza.smartcity.payment.business.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConfigurationProperties(prefix = "payment.confirmation")
@ConstructorBinding
data class PaymentConfirmationProperties(
    val randomSeed: Int,
    val confirmationThreshold: Int
)
