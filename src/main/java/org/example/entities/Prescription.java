package org.example.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "prescriptions")
@Data
@ToString(callSuper = true)
public class Prescription extends BaseEntities {
    @Column(name = "prescription_date")
    private LocalDate prescriptionDate;
    @Column(name = "medicines")
    private String medicines;
    @OneToOne
    @JoinColumn(name = "appointment_id")
    private Appointment appointment;
}
