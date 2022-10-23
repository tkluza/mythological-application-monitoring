package com.tkluza.smartcity.smartmobility.business.reservation.dto.event;

import lombok.Builder;

import java.util.UUID;

@Builder
public record ReservationCreatedEvent(
        UUID reservationBusinessKey
) {

}
