package com.booking.appointment_management_service.common.validators;

import com.booking.appointment_management_service.api.consultants.dto.AvailabilityDto;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * @author Hari Prasanth
 */
public class ValidTimeValidator implements ConstraintValidator<ValidTime, AvailabilityDto> {
    @Override
    public boolean isValid(AvailabilityDto value, ConstraintValidatorContext context) {
        if(value.getStartTime() == null || value.getEndTime() == null){
            return true;
        }

        return value.getStartTime().isBefore(value.getEndTime());
    }
}
