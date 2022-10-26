package com.tkluza.smartcity.smartmobility.business.reservation.domain.exception;

import com.tkluza.smartcity.smartmobility.common.BusinessException;

public class MaxNumberOfReservationsForUserException extends BusinessException {

    public MaxNumberOfReservationsForUserException(Long userId) {
        super("Number of reservation for user: " + userId + " has been reached.");
    }
}
