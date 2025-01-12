package com.booking.appointment_management_service.service.appointment;

import com.booking.appointment_management_service.api.appointments.dto.AppointmentRequestDto;
import com.booking.appointment_management_service.entity.Appointment;

/**
 * @author Hari Prasanth
 */
public interface AppointmentService {

    public Appointment bookAppointment(AppointmentRequestDto requestDto);
}
