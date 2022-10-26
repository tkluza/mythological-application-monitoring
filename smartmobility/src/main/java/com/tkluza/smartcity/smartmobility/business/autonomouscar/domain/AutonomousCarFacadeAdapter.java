package com.tkluza.smartcity.smartmobility.business.autonomouscar.domain;

import com.tkluza.smartcity.smartmobility.business.autonomouscar.domain.service.AutonomousCarService;
import com.tkluza.smartcity.smartmobility.business.autonomouscar.dto.query.AutonomousCarQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional
public class AutonomousCarFacadeAdapter implements AutonomousCarFacade {

    private final AutonomousCarService autonomousCarService;

    @Override
    public List<AutonomousCarQuery> findAllAutonomousCars() {
        return autonomousCarService.findAll();
    }
}
