package com.tkluza.smartcity.smartmobility.business.reservation.domain.service.adapter;

import com.tkluza.smartcity.smartmobility.business.reservation.domain.model.ReservationEntity;
import com.tkluza.smartcity.smartmobility.business.reservation.domain.model.ReservationId;
import com.tkluza.smartcity.smartmobility.business.reservation.domain.model.ReservationStatus;
import com.tkluza.smartcity.smartmobility.business.reservation.domain.repository.ReservationRepository;
import com.tkluza.smartcity.smartmobility.business.reservation.domain.service.ReservationService;
import com.tkluza.smartcity.smartmobility.business.reservation.dto.CancelReservationCommand;
import com.tkluza.smartcity.smartmobility.business.reservation.dto.ConfirmReservationCommand;
import com.tkluza.smartcity.smartmobility.business.reservation.dto.CreateReservationCommand;

import java.time.LocalDateTime;
import java.util.UUID;

import static java.util.Objects.requireNonNull;

public record ReservationServiceAdapter(
        ReservationRepository reservationRepository
) implements ReservationService {

    @Override
    public void create(CreateReservationCommand command) {

        validate(command);

        ReservationEntity entity = ReservationEntity.builder()
                .id(ReservationId.builder()
                        .autonomousCarId(command.autonomousCarId())
                        .userId(command.userId())
                        .reservationDate(LocalDateTime.now())
                        .build())
                .businessKey(UUID.randomUUID())
                .status(ReservationStatus.CREATED)
                .build();

        reservationRepository.save(entity);
    }

    private void validate(CreateReservationCommand command) {
        requireNonNull(command);
        requireNonNull(command);
        requireNonNull(command);
    }

    @Override
    public void change(ConfirmReservationCommand command) {

    }

    @Override
    public void cancel(CancelReservationCommand command) {

    }
}
