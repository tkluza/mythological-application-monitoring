package com.tkluza.smartcity.payment

import com.tkluza.smartcity.payment.business.routing.configurePaymentRouting
import com.tkluza.smartcity.payment.plugins.configureSerialization
import io.ktor.server.application.Application

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

fun Application.module() {
    configurePaymentRouting()
    configureSerialization()
}