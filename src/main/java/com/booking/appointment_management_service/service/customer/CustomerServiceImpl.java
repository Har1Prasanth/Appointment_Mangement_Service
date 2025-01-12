package com.booking.appointment_management_service.service.customer;

import com.booking.appointment_management_service.api.appointments.dto.AppointmentResponseDto;
import com.booking.appointment_management_service.api.customers.dto.CustomerResponseDto;
import com.booking.appointment_management_service.entity.Customer;
import com.booking.appointment_management_service.exception.ResourceNotFoundException;
import com.booking.appointment_management_service.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Hari Prasanth
 */
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository customerRepository;

    @Override
    public CustomerResponseDto getCustomerByEmail(String email) {

        Customer customer = customerRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with email: " + email));

        CustomerResponseDto customerResponseDto = new CustomerResponseDto();

        customerResponseDto.setName(customer.getName());
        customerResponseDto.setEmail(customer.getEmail());

        List<AppointmentResponseDto> appointments = customer.getAppointments().stream()
                .map(appointment -> new AppointmentResponseDto(
                    appointment.getAppointmentId(),
                        appointment.getConfirmationNumber(),
                        appointment.getAppointmentStartTime(),
                        appointment.getAppointmentEndTime()
                )).toList();

        customerResponseDto.setAppointments(appointments);
        return customerResponseDto;
    }
}
