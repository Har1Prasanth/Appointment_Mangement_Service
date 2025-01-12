package com.booking.appointment_management_service.api.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Hari Prasanth
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto {

    private String name;
    private String email;
    private Role role;
}
