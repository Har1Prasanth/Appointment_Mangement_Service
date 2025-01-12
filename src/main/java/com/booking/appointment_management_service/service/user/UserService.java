package com.booking.appointment_management_service.service.user;

import com.booking.appointment_management_service.api.user.dto.Role;
import com.booking.appointment_management_service.entity.User;

import java.util.List;

/**
 * @author Hari Prasanth
 */
public interface UserService {

    public User registerUser(User user);

    public User getUserByEmail(String email);

    public List<User> getAllUsers();

    public List<User> getAllUsersByRole(Role role);

}
