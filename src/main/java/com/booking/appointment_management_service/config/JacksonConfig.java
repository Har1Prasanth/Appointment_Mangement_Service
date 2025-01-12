package com.booking.appointment_management_service.config;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Hari Prasanth
 */
@Configuration
public class JacksonConfig {
 @Bean
 public Jackson2ObjectMapperBuilder jacksonBuilder() {
  Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
  builder.featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
  builder.serializerByType(LocalTime.class, new LocalTimeSerializer(DateTimeFormatter.ofPattern("HH:mm")));
  builder.deserializerByType(LocalTime.class, new LocalTimeDeserializer(DateTimeFormatter.ofPattern("HH:mm")));
  return builder;
 }
}
