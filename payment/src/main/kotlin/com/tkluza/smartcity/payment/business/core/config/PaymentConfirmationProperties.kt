package com.tkluza.smartcity.payment.business.core.config

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("payment.confirmation")
data class PaymentConfirmationProperties(
    var range: Int = 0,
    var threshold: Int = 0
)
