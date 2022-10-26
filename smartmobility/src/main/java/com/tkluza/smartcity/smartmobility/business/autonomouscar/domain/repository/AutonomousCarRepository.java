package com.tkluza.smartcity.smartmobility.business.autonomouscar.domain.repository;

import com.tkluza.smartcity.smartmobility.business.autonomouscar.domain.model.AutonomousCarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutonomousCarRepository extends JpaRepository<AutonomousCarEntity, Long> {

}
