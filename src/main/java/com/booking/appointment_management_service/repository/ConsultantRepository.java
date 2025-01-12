package com.booking.appointment_management_service.repository;

import com.booking.appointment_management_service.entity.Consultant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Hari Prasanth
 */
public interface ConsultantRepository extends JpaRepository<Consultant, Long> {

    Optional<Consultant> findByEmail(String email);


 }
