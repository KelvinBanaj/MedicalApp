package org.example.services;

import org.example.entities.Patient;
import org.example.entities.Payments;
import org.example.repositoires.PatientRepository;
import org.example.repositoires.PaymentRepository;

import java.time.LocalDate;
import java.util.List;

public class PaymentsServices {
    private final PaymentRepository paymentRepository;
    private final PatientRepository patientRepository;

    public PaymentsServices(PaymentRepository paymentRepository, PatientRepository patientRepository) {
        this.paymentRepository = paymentRepository;
        this.patientRepository = patientRepository;
    }

    public Payments createPayment(LocalDate date, Long patientId, double amount, String description){
        Patient patient = patientRepository.findById(patientId);
        Payments payments = new Payments();
        payments.setPaymentDate(date);
        payments.setAmount(amount);
        payments.setDescription(description);
        payments.setPatient(patient);
        return paymentRepository.save(payments);
    }

    public List<Payments> findByPatient(Long patientId){
        return paymentRepository.findByPatientId(patientId);
    }
}
