package com.tkluza.smartcity.smartmobility.business.reservation.domain.repository;

import com.tkluza.smartcity.smartmobility.business.reservation.domain.model.ReservationEntity;
import com.tkluza.smartcity.smartmobility.business.reservation.domain.model.ReservationId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ReservationRepository extends CrudRepository<ReservationEntity, ReservationId> {

    @Query("SELECT r FROM ReservationEntity r WHERE r.businessKey = :businessKey")
    Optional<ReservationEntity> findByBusinessKey(@Param("businessKey") UUID businessKey);

    @Query("""
            SELECT r
            FROM ReservationEntity r
            WHERE r.id.userId = :userId AND
                  r.status <> com.tkluza.smartcity.smartmobility.business.reservation.domain.model.ReservationStatus.CANCELLED
            """)
    List<ReservationEntity> findAllByUserId(@Param("userId") Long userId);

    @Query("""
            SELECT r
            FROM ReservationEntity r
            WHERE r.id.autonomousCarId = :autonomousCarId AND
                  r.status <> com.tkluza.smartcity.smartmobility.business.reservation.domain.model.ReservationStatus.CANCELLED
            """)
    List<ReservationEntity> findAllByAutonomousCarId(@Param("autonomousCarId") Long autonomousCarId);
}
