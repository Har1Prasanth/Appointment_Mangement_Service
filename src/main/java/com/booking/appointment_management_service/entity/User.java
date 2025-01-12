package com.booking.appointment_management_service.entity;

import com.booking.appointment_management_service.api.user.dto.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Hari Prasanth
 */
@Entity
@Getter
@Setter
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    private Boolean isAdmin;


}
