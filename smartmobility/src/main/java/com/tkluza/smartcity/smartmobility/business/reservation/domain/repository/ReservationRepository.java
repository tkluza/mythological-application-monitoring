package com.tkluza.smartcity.smartmobility.business.reservation.domain.repository;

import com.tkluza.smartcity.smartmobility.business.reservation.domain.model.ReservationEntity;
import com.tkluza.smartcity.smartmobility.business.reservation.domain.model.ReservationId;
import org.springframework.data.repository.CrudRepository;

public interface ReservationRepository extends CrudRepository<ReservationEntity, ReservationId> {

}
