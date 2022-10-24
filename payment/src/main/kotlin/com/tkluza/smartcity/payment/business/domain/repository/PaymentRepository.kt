package com.tkluza.smartcity.payment.business.domain.repository

import com.tkluza.smartcity.payment.business.domain.model.PaymentEntity
import org.springframework.data.repository.CrudRepository

interface PaymentRepository : CrudRepository<PaymentEntity, Long>