package com.tkluza.smartcity.smartmobility.business.reservation.domain.model;

import com.tkluza.smartcity.smartmobility.business.autonomouscar.domain.model.AutonomousCarEntity;
import com.tkluza.smartcity.smartmobility.business.user.domain.model.UserEntity;
import com.tkluza.smartcity.smartmobility.common.BusinessKey;
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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_reservation", uniqueConstraints = {
        @UniqueConstraint(
                name = "uc_reservation_business_key",
                columnNames = {"business_key"})
})
public class ReservationEntity {

    @EmbeddedId
    private ReservationId id;

    @NotNull
    @BusinessKey
    @Column(name = "business_key")
    private UUID businessKey;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "autonomous_car_id", insertable = false, updatable = false)
    private AutonomousCarEntity autonomousCarEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private UserEntity userEntity;

    @NotNull
    @Column(name = "status")
    @Enumerated(value = EnumType.STRING)
    private ReservationStatus status;

    @Column(name = "price")
    private BigDecimal price;
}
