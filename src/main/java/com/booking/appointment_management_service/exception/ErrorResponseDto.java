package com.booking.appointment_management_service.exception;

import lombok.*;

import java.time.LocalDateTime;

/**
 * @author Hari Prasanth
 */
@Data
@AllArgsConstructor
public class ErrorResponseDto {

    private LocalDateTime timestamp;
    private int status;
    private String message;
    private String path;


}
