package com.booking.appointment_management_service.api.appointments.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Hari Prasanth
 */
@Data
@AllArgsConstructor
public class AppointmentRequestDto {

    private Long customerId;
    private Long consultantId;
    //private Long serviceId;
    private LocalDateTime appointmentStartTime;
    private LocalDateTime appointmentEndTime;

}
