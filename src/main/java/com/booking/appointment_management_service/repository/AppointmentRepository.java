package com.booking.appointment_management_service.repository;

import com.booking.appointment_management_service.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Hari Prasanth
 */
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
