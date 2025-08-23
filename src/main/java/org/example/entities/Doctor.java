package org.example.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.sql.Time;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "doctors")
@Data
@ToString(callSuper = true)
public class Doctor extends BaseEntities {
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "specialization")
    @Enumerated(value = EnumType.STRING)
    private DoctorSpecialization doctorSpecialization;
    @Column(name = "contact_info")
    private String contactInfo;
    @Column(name = "start_work_at")
    private LocalTime startWorkAt;
    @Column(name = "end_work_at")
    private LocalTime endWorkAt;
    @OneToMany(mappedBy = "doctor")
    private List<Appointment>appointments;
}
