package com.booking.appointment_management_service.api.consultants.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @author Hari Prasanth
 */
@Data
@AllArgsConstructor
public class ConsultantRequestDto {

    private String specialization;
    private String email;
    private List<AvailabilityDto> availability;
}
