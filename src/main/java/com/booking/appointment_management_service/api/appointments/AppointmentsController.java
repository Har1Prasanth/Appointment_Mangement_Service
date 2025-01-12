package com.booking.appointment_management_service.api.appointments;

import com.booking.appointment_management_service.api.appointments.dto.AppointmentRequestDto;
import com.booking.appointment_management_service.entity.Appointment;
import com.booking.appointment_management_service.service.appointment.AppointmentService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Hari Prasanth
 */
@RestController
@RequestMapping("/api/v1/appointments")
@Data
@AllArgsConstructor
public class AppointmentsController {

 private final AppointmentService appointmentService;

 @PostMapping()
 public ResponseEntity<?> bookAppointment(@RequestBody AppointmentRequestDto requestDto) {
  Appointment appointment = appointmentService.bookAppointment(requestDto);
  return new ResponseEntity<>(
          "Appointment Booked Successfully with confirmation number: " + appointment.getConfirmationNumber(),
          HttpStatus.CREATED);
 }
}
