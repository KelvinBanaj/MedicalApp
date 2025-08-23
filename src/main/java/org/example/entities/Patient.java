package org.example.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "patients")
@Data
@ToString(callSuper = true)
public class Patient extends BaseEntities{
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "birth_date")
    private LocalDate birthDate;
    @Column(name = "NID", unique = true)
    private String nid;
    @Column(name = "contact_info")
    private String contactInfo;
    @Column(name = "medical_history")
    private String medicalHistory;
    @OneToMany(mappedBy = "patient")
    private List<Appointment>appointments;
    @OneToMany(mappedBy = "patient")
    private List<Payments>payments;

    public void addAppointment(Appointment appointment){
        if(this.getAppointments()==null||this.getAppointments().isEmpty()) {
            List<Appointment> appointmentList = new ArrayList<Appointment>();
            appointmentList.add(appointment);
            this.setAppointments(appointmentList);
        }else{
            this.getAppointments().add(appointment);
        }
    }

}
