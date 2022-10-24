package com.tkluza.smartcity.payment.business.domain.model

import java.time.LocalDateTime
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "t_payment")
class PaymentEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = -1,

    @Column(name = "reservation_external_business_key")
    val reservationExternalBusinessKey: UUID,

    @Column(name = "status")
    @Enumerated(value = EnumType.STRING)
    var status: PaymentStatus? = null,

    @Column(name = "date")
    var date: LocalDateTime? = null,
)