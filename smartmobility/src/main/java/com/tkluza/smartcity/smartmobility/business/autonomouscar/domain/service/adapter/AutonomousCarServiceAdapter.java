package com.tkluza.smartcity.smartmobility.business.autonomouscar.domain.service.adapter;

import com.tkluza.smartcity.smartmobility.business.autonomouscar.domain.mapper.AutonomousCarMapper;
import com.tkluza.smartcity.smartmobility.business.autonomouscar.domain.repository.AutonomousCarRepository;
import com.tkluza.smartcity.smartmobility.business.autonomouscar.domain.service.AutonomousCarService;
import com.tkluza.smartcity.smartmobility.business.autonomouscar.dto.query.AutonomousCarQuery;

import java.util.List;

public record AutonomousCarServiceAdapter(
        AutonomousCarRepository autonomousCarRepository,
        AutonomousCarMapper autonomousCarMapper
) implements AutonomousCarService {

    @Override
    public List<AutonomousCarQuery> findAll() {
        return autonomousCarRepository.findAll()
                .stream()
                .map(autonomousCarMapper::map)
                .toList();
    }
}
