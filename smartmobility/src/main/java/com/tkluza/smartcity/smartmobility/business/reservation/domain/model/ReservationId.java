package com.tkluza.smartcity.smartmobility.business.reservation.domain.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

@Embeddable
@Data
public class ReservationId implements Serializable {

    @NotNull
    @Column(name = "autonomous_car_id")
    private Long autonomousCarId;

    @NotNull
    @Column(name = "user_id")
    private Long userId;

    @NotNull
    @Column(name = "reservation_date")
    private LocalDateTime reservationDate;
}
