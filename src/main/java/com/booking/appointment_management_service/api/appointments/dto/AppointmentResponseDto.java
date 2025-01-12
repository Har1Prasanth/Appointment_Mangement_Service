package com.booking.appointment_management_service.api.appointments.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Hari Prasanth
 */
@Data
@AllArgsConstructor
public class AppointmentResponseDto {
    private Long appointmentId;
    private String confirmationNumber;
    private LocalDateTime appointmentStartTime;
    private LocalDateTime appointmentEndTime;
}
