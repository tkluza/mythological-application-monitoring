package com.tkluza.smartcity.smartmobility.business.autonomouscar.domain.mapper;

import com.tkluza.smartcity.smartmobility.business.autonomouscar.domain.model.AutonomousCarEntity;
import com.tkluza.smartcity.smartmobility.business.autonomouscar.dto.query.AutonomousCarQuery;

import java.util.Objects;

public record AutonomousCarMapper() {

    public AutonomousCarQuery map(AutonomousCarEntity entity) {
        Objects.requireNonNull(entity);

        return AutonomousCarQuery.builder()
                .id(entity.getId())
                .model(entity.getModel())
                .manufacturer(entity.getManufacturer())
                .numberOfSeats(entity.getNumberOfSeats())
                .registrationPlate(entity.getRegistrationPlate())
                .batteryLevel(entity.getBatteryLevel())
                .build();
    }
}
