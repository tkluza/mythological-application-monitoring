package com.tkluza.smartcity.smartmobility.business.reservation.domain.exception;

import com.tkluza.smartcity.smartmobility.common.BusinessException;

public class MaxNumberOfReservationsForAutonomousCarException extends BusinessException {

    public MaxNumberOfReservationsForAutonomousCarException(Long autonomousCarId) {
        super("Number of reservation for autonomous car: " + autonomousCarId + " has been reached.");
    }
}
