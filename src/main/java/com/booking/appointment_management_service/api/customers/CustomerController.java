package com.booking.appointment_management_service.api.customers;

import com.booking.appointment_management_service.api.customers.dto.CustomerResponseDto;
import com.booking.appointment_management_service.service.customer.CustomerService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Hari Prasanth
 */
@RestController
@RequestMapping("/api/v1/customers")
@AllArgsConstructor
@Data
public class CustomerController {

 private final CustomerService customerService;



 @GetMapping("/{email}")
 public ResponseEntity<CustomerResponseDto> getCustomer(@PathVariable("email") String email){
     CustomerResponseDto customerResponseDto = customerService.getCustomerByEmail(email);
      return ResponseEntity.ok(customerResponseDto);
 }


}
