package com.booking.appointment_management_service.repository;

import com.booking.appointment_management_service.entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Hari Prasanth
 */
public interface ServiceRepository extends JpaRepository<Service,Long> {
}
