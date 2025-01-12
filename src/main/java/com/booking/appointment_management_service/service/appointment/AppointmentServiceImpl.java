package com.booking.appointment_management_service.service.appointment;

import com.booking.appointment_management_service.api.appointments.dto.AppointmentRequestDto;
import com.booking.appointment_management_service.entity.Appointment;
import com.booking.appointment_management_service.entity.Consultant;
import com.booking.appointment_management_service.entity.Customer;
import com.booking.appointment_management_service.exception.ResourceNotFoundException;
import com.booking.appointment_management_service.repository.AppointmentRepository;
import com.booking.appointment_management_service.repository.ConsultantRepository;
import com.booking.appointment_management_service.repository.CustomerRepository;
import com.booking.appointment_management_service.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author Hari Prasanth
 */
@Service
@AllArgsConstructor
@Data
public class AppointmentServiceImpl implements AppointmentService {

    private final UserRepository userRepository;
    private final CustomerRepository customerRepository;
    private final ConsultantRepository consultantRepository;
    private final AppointmentRepository appointmentRepository;

    @Override
    @Transactional
    public Appointment bookAppointment(AppointmentRequestDto request) {

        Customer customer = customerRepository.findById(request.getCustomerId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + request.getCustomerId()));

        Consultant consultant = consultantRepository.findById(request.getConsultantId())
                .orElseThrow(() -> new ResourceNotFoundException("Consultant not found with id: " + request.getConsultantId()));

        Appointment appointment = new Appointment();
        appointment.setCustomer(customer);
        appointment.setConsultant(consultant);
        appointment.setAppointmentStartTime(request.getAppointmentStartTime());
        appointment.setAppointmentEndTime(request.getAppointmentEndTime());
        appointment.setConfirmationNumber(UUID.randomUUID().toString());
        return appointmentRepository.save(appointment);

    }
}
