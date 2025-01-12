package com.booking.appointment_management_service.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author Hari Prasanth
 */
@Entity
@Getter
@Setter
@ToString(exclude = {"customer", "consultant"})
@EqualsAndHashCode(exclude = {"customer", "consultant"})
@Table(name = "appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appointmentId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonBackReference
    private Customer customer;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonBackReference
    private Consultant consultant;

    @ManyToOne
    @JsonIgnore
    private Service service;

    @Column(nullable = false)
    private LocalDateTime appointmentStartTime;

    @Column(nullable = false)
    private LocalDateTime appointmentEndTime;

    @Column(unique = true,nullable = false)
    private String confirmationNumber;

    //Audit Fields
    @CreatedBy
    @JsonIgnore
    private String createdBy;

    @CreatedDate
    @JsonIgnore
    private LocalDate createdOn;

    @LastModifiedBy
    @JsonIgnore
    private String lastModifiedBy;

    @LastModifiedDate
    @JsonIgnore
    private LocalDate lastModifiedOn;
}
