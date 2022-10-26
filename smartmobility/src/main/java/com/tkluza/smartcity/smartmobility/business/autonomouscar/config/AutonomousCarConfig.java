package com.tkluza.smartcity.smartmobility.business.autonomouscar.config;

import com.tkluza.smartcity.smartmobility.business.autonomouscar.domain.AutonomousCarFacade;
import com.tkluza.smartcity.smartmobility.business.autonomouscar.domain.AutonomousCarFacadeAdapter;
import com.tkluza.smartcity.smartmobility.business.autonomouscar.domain.mapper.AutonomousCarMapper;
import com.tkluza.smartcity.smartmobility.business.autonomouscar.domain.repository.AutonomousCarRepository;
import com.tkluza.smartcity.smartmobility.business.autonomouscar.domain.service.AutonomousCarService;
import com.tkluza.smartcity.smartmobility.business.autonomouscar.domain.service.adapter.AutonomousCarServiceAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AutonomousCarConfig {

    @Bean
    AutonomousCarFacade autonomousCarFacade(AutonomousCarRepository autonomousCarRepository) {
        AutonomousCarService autonomousCarService = new AutonomousCarServiceAdapter(
                autonomousCarRepository,
                new AutonomousCarMapper()
        );

        return new AutonomousCarFacadeAdapter(autonomousCarService);
    }
}
