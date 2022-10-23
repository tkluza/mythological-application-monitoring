package com.tkluza.smartcity.smartmobility.business.reservation.domain.service.adapter;

import com.tkluza.smartcity.smartmobility.business.reservation.domain.gateway.ReservationGateway;
import com.tkluza.smartcity.smartmobility.business.reservation.domain.model.ReservationEntity;
import com.tkluza.smartcity.smartmobility.business.reservation.domain.model.ReservationId;
import com.tkluza.smartcity.smartmobility.business.reservation.domain.model.ReservationStatus;
import com.tkluza.smartcity.smartmobility.business.reservation.domain.repository.ReservationRepository;
import com.tkluza.smartcity.smartmobility.business.reservation.domain.service.ReservationService;
import com.tkluza.smartcity.smartmobility.business.reservation.dto.command.CancelReservationCommand;
import com.tkluza.smartcity.smartmobility.business.reservation.dto.command.ConfirmReservationCommand;
import com.tkluza.smartcity.smartmobility.business.reservation.dto.command.CreateReservationCommand;
import com.tkluza.smartcity.smartmobility.business.reservation.dto.event.ReservationCreatedEvent;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.UUID;
import java.util.function.Consumer;

import static java.util.Objects.requireNonNull;

public record ReservationServiceAdapter(
        ReservationGateway reservationGateway,
        ReservationRepository reservationRepository
) implements ReservationService {

    @Override
    public void create(CreateReservationCommand command) {

        validateCreation(command);

        UUID reservationBusinessKey = UUID.randomUUID();

        ReservationEntity entity = ReservationEntity.builder()
                .id(ReservationId.builder()
                        .autonomousCarId(command.autonomousCarId())
                        .userId(command.userId())
                        .reservationDate(LocalDateTime.now())
                        .build())
                .businessKey(reservationBusinessKey)
                .status(ReservationStatus.CREATED)
                .build();

        reservationRepository.save(entity);

        reservationGateway.publishEvent(
                ReservationCreatedEvent.builder()
                        .reservationBusinessKey(reservationBusinessKey)
                        .build()
        );
    }

    private void validateCreation(CreateReservationCommand command) {
        requireNonNull(command);
        requireNonNull(command);
        requireNonNull(command);
    }

    @Override
    public void confirm(ConfirmReservationCommand command) {
        validateConfirmation(command);

        update(command.reservationBusinessKey(),
                reservationEntity -> {
                    reservationEntity.setStatus(ReservationStatus.CONFIRMED);
                    reservationEntity.setPrice(command.price());
                }
        );
    }

    private void validateConfirmation(ConfirmReservationCommand command) {
        requireNonNull(command);
        requireNonNull(command.price());
        requireNonNull(command.reservationBusinessKey());
    }

    private void update(UUID businessKey, Consumer<ReservationEntity> consumer) {
        reservationRepository.findByBusinessKey(businessKey)
                .ifPresentOrElse(
                        consumer,
                        () -> {
                            throw new EntityNotFoundException();
                        }
                );
    }

    @Override
    public void cancel(CancelReservationCommand command) {
        validateCancellation(command);

        update(command.reservationBusinessKey(),
                reservationEntity -> reservationEntity.setStatus(ReservationStatus.CANCELLED)
        );
    }

    private void validateCancellation(CancelReservationCommand command) {
        requireNonNull(command);
        requireNonNull(command.reservationBusinessKey());
    }
}
