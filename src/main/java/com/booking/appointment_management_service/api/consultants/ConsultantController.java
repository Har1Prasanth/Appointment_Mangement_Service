package com.booking.appointment_management_service.api.consultants;

import com.booking.appointment_management_service.api.consultants.dto.ConsultantRequestDto;
import com.booking.appointment_management_service.api.consultants.dto.ConsultantResponseDto;
import com.booking.appointment_management_service.service.consultant.ConsultantService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Hari Prasanth
 */
@RestController
@RequestMapping("/api/v1/consultants")
@AllArgsConstructor
@Data
public class ConsultantController {

 private final ConsultantService consultantService;

 @PostMapping
 public ResponseEntity<?> createConsultant(@RequestBody ConsultantRequestDto consultant){
     return ResponseEntity.ok(consultantService.createConsultant(consultant));
 }

 @GetMapping("/{email}")
 public ResponseEntity<ConsultantResponseDto> getConsultant(@PathVariable("email") String email){
      ConsultantResponseDto consultantResponseDto = consultantService.getConsultantByEmail(email);
      return ResponseEntity.ok(consultantResponseDto);
 }


}
