package com.booking.appointment_management_service.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hari Prasanth
 */
@Entity
@Getter
@Setter
@ToString(exclude = {"availability", "appointments"})
@EqualsAndHashCode(exclude = {"availability", "appointments"})
@Table(name = "consultants")
public class Consultant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long consultantId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String specialization;

    @OneToMany(mappedBy = "consultant", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<ConsultantAvailability> availability = new ArrayList<>();

    @OneToMany(mappedBy = "consultant", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Appointment> appointments = new ArrayList<>();

}
