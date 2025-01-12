package com.booking.appointment_management_service.exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.nio.file.AccessDeniedException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Hari Prasanth
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class GlobalExceptionHandler {

   private static final Map<Class<? extends Exception>,HttpStatus> EXCEPTION_STATUS_MAP = new HashMap<>();

   static {
      EXCEPTION_STATUS_MAP.put(IllegalAccessException.class, HttpStatus.BAD_REQUEST);
      EXCEPTION_STATUS_MAP.put(AccessDeniedException.class, HttpStatus.FORBIDDEN);
      EXCEPTION_STATUS_MAP.put(ResourceNotFoundException.class,HttpStatus.NOT_FOUND);
   }


   @ExceptionHandler(Exception.class)
   public ResponseEntity<ErrorResponseDto> handleException(Exception ex, WebRequest request){
      HttpStatus status = EXCEPTION_STATUS_MAP.getOrDefault(ex.getClass(),HttpStatus.INTERNAL_SERVER_ERROR);
      String message = ex.getMessage()!=null ? ex.getMessage() : "An unexpected error occurred. Please try again.";
      ErrorResponseDto errorResponse = new ErrorResponseDto(
              LocalDateTime.now(),
              status.value(),
              message,
              request.getDescription(false)
      );
      return new ResponseEntity<>(errorResponse, status);
   }

}
