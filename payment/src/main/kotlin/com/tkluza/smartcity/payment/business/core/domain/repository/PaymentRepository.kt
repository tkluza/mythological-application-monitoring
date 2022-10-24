package com.tkluza.smartcity.payment.business.core.domain.repository

import com.tkluza.smartcity.payment.business.core.domain.model.PaymentEntity
import org.springframework.data.repository.CrudRepository

interface PaymentRepository : CrudRepository<PaymentEntity, Long> {}