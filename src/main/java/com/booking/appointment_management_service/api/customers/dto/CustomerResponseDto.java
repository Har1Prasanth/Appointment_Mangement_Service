package com.booking.appointment_management_service.api.customers.dto;

import com.booking.appointment_management_service.api.appointments.dto.AppointmentResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Hari Prasanth
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponseDto {

    private String name;
    private String email;
    private List<AppointmentResponseDto> appointments;
}
