package org.example;

import org.example.entities.Doctor;
import org.example.entities.DoctorSpecialization;
import org.example.entities.Patient;
import org.example.repositoires.*;
import org.example.services.AppointmentServices;
import org.example.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();

        AppointmentRepository appointmentRepository = new AppointmentRepository(session);
        DoctorRepository doctorRepository = new DoctorRepository(session);
        PatientRepository patientRepository = new PatientRepository(session);
        PaymentRepository paymentRepository = new PaymentRepository(session);
        PrescriptionRepository prescriptionRepository = new PrescriptionRepository(session);
        AppointmentServices appointmentServices = new AppointmentServices(appointmentRepository,doctorRepository,patientRepository);

//        Patient patient = new Patient();
//        patient.setFirstName("Kelvin");
//        patient.setLastName("Banaj");
//        patient.setNid("123456");
//        patient.setBirthDate(LocalDate.of(2006,9,13));
//        patient.setContactInfo("03748929");
//        patient.setMedicalHistory("Nuk ka");

//        System.out.println(patientRepository.save(patient));

//        Doctor doctor = new Doctor();
//        doctor.setFirstName("Andrea");
//        doctor.setLastName("Dollaku");
//        doctor.setDoctorSpecialization(DoctorSpecialization.Pediatrician);
//        doctor.setContactInfo("andrea@gmail.com");
//        doctor.setStartWorkAt(LocalTime.of(8,0));
//        doctor.setEndWorkAt(LocalTime.of(20,0));
//
//        System.out.println(doctorRepository.save(doctor));

    }
}
