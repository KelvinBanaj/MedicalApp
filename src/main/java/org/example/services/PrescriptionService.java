package org.example.services;

import jakarta.persistence.Enumerated;
import org.example.entities.Appointment;
import org.example.entities.AppointmentStatus;
import org.example.entities.Prescription;
import org.example.repositoires.AppointmentRepository;
import org.example.repositoires.PrescriptionRepository;
import java.time.LocalDate;
import java.util.List;

public class PrescriptionService {
    private final AppointmentRepository appointmentRepository;
    private final PrescriptionRepository prescriptionRepository;

    public PrescriptionService(AppointmentRepository appointmentRepository, PrescriptionRepository prescriptionRepository) {
        this.appointmentRepository = appointmentRepository;
        this.prescriptionRepository = prescriptionRepository;
    }

    public Prescription createPrescription (LocalDate date, Long appointmentId, String medicine){
        Appointment appointment = appointmentRepository.findById(appointmentId);
        Prescription prescription = new Prescription();
        prescription.setAppointment(appointment);
        prescription.setPrescriptionDate(date);
        prescription.setMedicines(medicine);
        appointment.setAppointmentStatus(AppointmentStatus.PLOTESUAR);
        appointmentRepository.save(appointment);
        return prescriptionRepository.save(prescription);
    }

    public List<Prescription> findByAppointment(Long appointmentId){
        return prescriptionRepository.findByAppointment(appointmentId);
    }
}
