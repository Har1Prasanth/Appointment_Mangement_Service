package com.booking.appointment_management_service.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.DayOfWeek;
import java.time.LocalTime;

/**
 * @author Hari Prasanth
 */
@Entity
@Data
@Table(name = "consultant_availability")
public class ConsultantAvailability {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonIgnore
    private Consultant consultant;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private DayOfWeek day; // e.g., "Monday"

    @Column(nullable = false)
    private LocalTime startTime;

    @Column(nullable = false)
    private LocalTime endTime;

}
