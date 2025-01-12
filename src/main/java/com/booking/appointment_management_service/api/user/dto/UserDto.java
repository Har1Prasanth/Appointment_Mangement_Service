package com.booking.appointment_management_service.api.user.dto;

import lombok.Data;

/**
 * @author Hari Prasanth
 */
@Data
public class UserDto {

    private String name;
    private String email;
    private String password;
    private Role role;
}
