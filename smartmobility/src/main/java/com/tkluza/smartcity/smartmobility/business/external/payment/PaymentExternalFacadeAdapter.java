package com.tkluza.smartcity.smartmobility.business.external.payment;

import com.tkluza.smartcity.smartmobility.business.external.payment.http.PaymentExternalHttpClient;
import com.tkluza.smartcity.smartmobility.business.reservation.dto.event.ReservationCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Transactional
@RequiredArgsConstructor
public class PaymentExternalFacadeAdapter implements PaymentExternalFacade {

    private final PaymentExternalHttpClient httpClient;

    @Override
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void processEvent(ReservationCreatedEvent event) {
        httpClient.sendRequest(event);
    }
}
