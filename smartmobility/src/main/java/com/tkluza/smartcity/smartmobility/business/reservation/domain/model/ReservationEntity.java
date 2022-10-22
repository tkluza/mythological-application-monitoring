package com.tkluza.smartcity.smartmobility.business.reservation.domain.model;

import com.tkluza.smartcity.smartmobility.business.autonomouscar.domain.model.AutonomousCarEntity;
import com.tkluza.smartcity.smartmobility.business.user.domain.model.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_reservation")
public class ReservationEntity {

    @EmbeddedId
    private ReservationId id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId(value = "autonomousCarId")
    private AutonomousCarEntity autonomousCarEntity;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId(value = "userId")
    private UserEntity userEntity;

    @NotNull
    @Column(name = "status")
    @Enumerated(value = EnumType.STRING)
    private ReservationStatus status;

    @NotNull
    @Column(name = "price")
    private BigDecimal price;
}
