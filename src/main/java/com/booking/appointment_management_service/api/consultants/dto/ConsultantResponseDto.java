package com.booking.appointment_management_service.api.consultants.dto;

import com.booking.appointment_management_service.api.appointments.dto.AppointmentResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @author Hari Prasanth
 */
@Data
@AllArgsConstructor
public class ConsultantResponseDto {

 private Long consultantId;
 private String name;
 private String specialization;
 private List<AvailabilityDto> availability;

 private List<AppointmentResponseDto> appointments;
}
