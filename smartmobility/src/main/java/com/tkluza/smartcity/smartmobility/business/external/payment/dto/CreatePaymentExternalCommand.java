package com.tkluza.smartcity.smartmobility.business.external.payment.dto;

import lombok.Builder;

import java.util.UUID;

@Builder
public record CreatePaymentExternalCommand(
        UUID reservationBusinessKey
) {

}
