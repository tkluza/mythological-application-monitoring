package com.tkluza.smartcity.payment

import com.tkluza.smartcity.payment.plugins.configureRouting
import com.tkluza.smartcity.payment.plugins.configureSerialization
import io.ktor.server.application.Application

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

fun Application.module() {
    configureRouting()
    configureSerialization()
}