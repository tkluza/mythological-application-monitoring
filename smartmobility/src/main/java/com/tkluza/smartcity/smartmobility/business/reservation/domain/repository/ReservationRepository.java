package com.tkluza.smartcity.smartmobility.business.reservation.domain.repository;

import com.tkluza.smartcity.smartmobility.business.reservation.domain.model.ReservationEntity;
import com.tkluza.smartcity.smartmobility.business.reservation.domain.model.ReservationId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface ReservationRepository extends CrudRepository<ReservationEntity, ReservationId> {

    @Query("SELECT r FROM ReservationEntity r WHERE r.businessKey = :businessKey")
    Optional<ReservationEntity> findByBusinessKey(@Param("businessKey") UUID businessKey);
}
