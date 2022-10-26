package com.tkluza.smartcity.smartmobility.business.autonomouscar.domain;

import com.tkluza.smartcity.smartmobility.business.autonomouscar.dto.query.AutonomousCarQuery;

import java.util.List;

/**
 * Main entry point to AutonomousCar domain.
 */
public interface AutonomousCarFacade {

    /**
     * Finds list of all autonomous cars.
     *
     * @return autonomous cars
     */
    List<AutonomousCarQuery> findAllAutonomousCars();
}
