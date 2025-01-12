package com.booking.appointment_management_service.repository;

import com.booking.appointment_management_service.entity.ConsultantAvailability;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Hari Prasanth
 */
public interface ConsultantAvailabilityRepository extends JpaRepository<ConsultantAvailability, Long> {
}
