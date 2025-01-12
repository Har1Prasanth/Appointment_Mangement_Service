package com.booking.appointment_management_service.repository;

import com.booking.appointment_management_service.api.user.dto.Role;
import com.booking.appointment_management_service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Hari Prasanth
 */
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    List<User> findByRole(Role role);
}
