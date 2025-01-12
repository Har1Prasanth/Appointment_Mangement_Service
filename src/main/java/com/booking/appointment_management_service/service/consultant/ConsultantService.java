package com.booking.appointment_management_service.service.consultant;

import com.booking.appointment_management_service.api.consultants.dto.ConsultantRequestDto;
import com.booking.appointment_management_service.api.consultants.dto.ConsultantResponseDto;
import com.booking.appointment_management_service.entity.Consultant;

/**
 * @author Hari Prasanth
 */
public interface ConsultantService {

    public Consultant createConsultant(ConsultantRequestDto consultant);

    ConsultantResponseDto getConsultantByEmail(String email);
//
//    public User getUserByEmail(String email);
//
//    public List<User> getAllUsers();
//
//    public List<User> getAllUsersByRole(Role role);

}
