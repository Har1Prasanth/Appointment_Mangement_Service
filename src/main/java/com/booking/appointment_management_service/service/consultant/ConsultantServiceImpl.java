package com.booking.appointment_management_service.service.consultant;

import com.booking.appointment_management_service.api.appointments.dto.AppointmentResponseDto;
import com.booking.appointment_management_service.api.consultants.dto.AvailabilityDto;
import com.booking.appointment_management_service.api.consultants.dto.ConsultantRequestDto;
import com.booking.appointment_management_service.api.consultants.dto.ConsultantResponseDto;
import com.booking.appointment_management_service.entity.Consultant;
import com.booking.appointment_management_service.entity.ConsultantAvailability;
import com.booking.appointment_management_service.entity.User;
import com.booking.appointment_management_service.exception.ResourceNotFoundException;
import com.booking.appointment_management_service.repository.ConsultantRepository;
import com.booking.appointment_management_service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Hari Prasanth
 */
@Service
@RequiredArgsConstructor
public class ConsultantServiceImpl implements ConsultantService {

    private final ConsultantRepository consultantRepository;
    private final UserRepository userRepository;

    @Override
    public Consultant createConsultant(ConsultantRequestDto consultantRequestDto) {

        //Find user by email
        User consultantUser = userRepository.findByEmail(consultantRequestDto.getEmail())
                .orElseThrow(() -> new ResourceNotFoundException("Consulant not found with email: " + consultantRequestDto.getEmail()));

        Consultant consultant = new Consultant();
        consultant.setName(consultantUser.getName());
        consultant.setEmail(consultantUser.getEmail());
        consultant.setSpecialization(consultantRequestDto.getSpecialization());

        List<ConsultantAvailability> availability = consultantRequestDto.getAvailability().stream()
                .map(dto -> {
                    ConsultantAvailability avail = new ConsultantAvailability();
                    avail.setDay(dto.getDay());
                    avail.setStartTime(dto.getStartTime());
                    avail.setEndTime(dto.getEndTime());
                    avail.setConsultant(consultant);
                    return avail;
                }).toList();

        consultant.setAvailability(availability);

        return consultantRepository.save(consultant);
    }

    @Override
    public ConsultantResponseDto getConsultantByEmail(String email) {
        Consultant consultant =consultantRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Consulant not found with email: " + email));

       List<AvailabilityDto> availabilityDtos = consultant.getAvailability().stream()
                .map(availability -> new AvailabilityDto(
                        availability.getDay(),
                        availability.getStartTime(),
                        availability.getEndTime()
                ))
                .toList();

       List<AppointmentResponseDto> appointments = consultant.getAppointments().stream()
               .map(appointment -> new AppointmentResponseDto(
                       appointment.getAppointmentId(),
                       appointment.getConfirmationNumber(),
                       appointment.getAppointmentStartTime(),
                       appointment.getAppointmentEndTime()
               )).toList();

        return new ConsultantResponseDto(
                consultant.getConsultantId(),
                consultant.getName(),
                consultant.getSpecialization(),
                availabilityDtos,
                appointments
        );
    }
}
