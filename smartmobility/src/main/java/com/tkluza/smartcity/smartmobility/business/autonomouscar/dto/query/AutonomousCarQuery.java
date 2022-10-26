package com.tkluza.smartcity.smartmobility.business.autonomouscar.dto.query;

import com.tkluza.smartcity.smartmobility.business.autonomouscar.domain.model.Manufacturer;
import lombok.Builder;

@Builder
public record AutonomousCarQuery(
        Long id,
        String model,
        Manufacturer manufacturer,
        short numberOfSeats,
        String registrationPlate,
        double batteryLevel
) {

}
