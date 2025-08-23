package org.example.services;

import org.example.entities.Appointment;
import org.example.entities.AppointmentStatus;
import org.example.entities.Doctor;
import org.example.entities.Patient;
import org.example.repositoires.AppointmentRepository;
import org.example.repositoires.DoctorRepository;
import org.example.repositoires.PatientRepository;

import java.time.LocalDateTime;
import java.util.List;

public class AppointmentServices {
    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    public AppointmentServices(AppointmentRepository appointmentRepository, DoctorRepository doctorRepository, PatientRepository patientRepository) {
        this.appointmentRepository = appointmentRepository;
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
    }

    public Appointment createAppointment(String reason, LocalDateTime date, Long patientId, Long doctorId) {
        Patient patient = patientRepository.findById(patientId);
        Doctor doctor = doctorRepository.findById(doctorId);
        Appointment appointment = new Appointment();
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);
        appointment.setAppointmentStatus(AppointmentStatus.REZERVUAR);
        appointment.setPurpose(reason);
        appointment.setAppointmentTime(date);
        return appointmentRepository.save(appointment);
    }

    public List<Appointment> findByPatient(Long patientId){
        return appointmentRepository.findByPatientId(patientId);
    }

    public List<Appointment> findByDoctor(Long doctorId){
        return appointmentRepository.findByDoctorId(doctorId);
    }
}
