package com.booking.appointment_management_service.service.customer;

import com.booking.appointment_management_service.api.customers.dto.CustomerResponseDto;

/**
 * @author Hari Prasanth
 */
public interface CustomerService {

    CustomerResponseDto getCustomerByEmail(String email);
}
