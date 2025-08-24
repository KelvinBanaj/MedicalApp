package org.example.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.sql.Time;
import java.time.LocalDateTime;

@Entity
@Table(name = "appointments")
@Data
@ToString(callSuper = true)
public class Appointment extends BaseEntities {
    @Column(name="appointment_time")
    private LocalDateTime appointmentTime;
    @Column(name= "purpose")
    private String purpose;
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;
    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;
    @Column(name = "status")
    @Enumerated(value = EnumType.STRING)
    private AppointmentStatus appointmentStatus;
}
