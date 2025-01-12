package com.booking.appointment_management_service.api.consultants.dto;

import com.booking.appointment_management_service.common.validators.ValidTime;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.DayOfWeek;
import java.time.LocalTime;

/**
 * @author Hari Prasanth
 */
@ValidTime
@Data
@AllArgsConstructor
public class AvailabilityDto {

  @NotNull
  private DayOfWeek day;

  @NotNull
  @JsonFormat(shape = JsonFormat.Shape.STRING ,pattern = "HH:mm")
  @Schema(type = "string", example = "10:00", format = "HH:mm")
  private LocalTime startTime;

  @NotNull
  @JsonFormat(shape = JsonFormat.Shape.STRING ,pattern = "HH:mm")
  @Schema(type = "string", example = "10:00", format = "HH:mm")
  private LocalTime endTime;

}
