package com.booking.appointment_management_service;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author Hari Prasanth
 */
@SpringBootApplication
public class AppointmentManagementServiceApplication {
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper(); // No additional configuration needed for enums
	}

	public static void main(String[] args) {
		SpringApplication.run(AppointmentManagementServiceApplication.class, args);
	}


}
