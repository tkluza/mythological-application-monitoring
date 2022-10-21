package com.tkluza.smartcity.smartmobility.business.autonomouscar.domain.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_autonomous_car")
public class AutonomousCarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "model")
    private String model;

    @NotNull
    @Column(name = "manufacturer")
    @Enumerated(value = EnumType.STRING)
    private Manufacturer manufacturer;

    @NotNull
    @Column(name = "number_of_seats")
    private short numberOfSeats;

    @NotNull
    @Column(name = "registration_plate")
    private String registrationPlate;

    @NotNull
    @Column(name = "battery_level")
    private double batteryLevel;
}