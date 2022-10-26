package com.tkluza.smartcity.smartmobility.business.autonomouscar.domain.service;

import com.tkluza.smartcity.smartmobility.business.autonomouscar.dto.query.AutonomousCarQuery;

import java.util.List;

public interface AutonomousCarService {

    List<AutonomousCarQuery> findAll();
}
