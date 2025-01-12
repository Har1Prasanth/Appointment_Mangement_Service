package com.booking.appointment_management_service.service.user;

import com.booking.appointment_management_service.api.user.dto.Role;
import com.booking.appointment_management_service.entity.Customer;
import com.booking.appointment_management_service.entity.User;
import com.booking.appointment_management_service.repository.ConsultantRepository;
import com.booking.appointment_management_service.repository.CustomerRepository;
import com.booking.appointment_management_service.repository.UserRepository;
import com.booking.appointment_management_service.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Hari Prasanth
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ConsultantRepository consultantRepository;
    private final CustomerRepository customerRepository;

    @Override
    public User registerUser(User user) {

        if (user.getRole() == Role.ADMIN) {
            user.setIsAdmin(true);
        } else {
            user.setIsAdmin(false);
        }
        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
        userRepository.save(user);

        if(user.getRole() == Role.CUSTOMER){
            createCustomerForUser(user);
        }
        return user;
    }

    private void createCustomerForUser(User user) {

        Customer customer = new Customer();
        customer.setName(user.getName());
        customer.setEmail(user.getEmail());

        customerRepository.save(customer);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();
        consultantRepository.findAll();
        return users;
    }

    @Override
    public List<User> getAllUsersByRole(Role role) {
        return userRepository.findByRole(role);
    }
}
