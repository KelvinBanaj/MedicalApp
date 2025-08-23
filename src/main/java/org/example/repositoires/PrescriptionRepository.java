package org.example.repositoires;

import org.example.entities.Appointment;
import org.example.entities.Prescription;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.util.List;

public class PrescriptionRepository extends GenericRepositories<Prescription,Long> {
    private final Session session;

    public PrescriptionRepository(Session session) {
        super(session, Prescription.class);
        this.session = session;
    }

    public List<Prescription> findByDate(LocalDate prescriptionDate) {
        String query = "select p from Prescription p where p.prescriptionDate = :prescriptionDate";
        Query<Prescription> findQuery = session.createQuery(query, Prescription.class);
        findQuery.setParameter("prescriptionDate", prescriptionDate);
        return findQuery.getResultList();
    }

    public List<Prescription> findByMedicine(String medicine){
        String query = "select p from Prescription p where p.medicine like :medicine";
        Query<Prescription> findQuery = session.createQuery(query, Prescription.class);
        findQuery.setParameter("medicine","%"+medicine);
        return findQuery.getResultList();
    }

    public List<Prescription> findByAppointment(Long appointmentId){
        String query = "select p from Prescription p where p.appointment.id = :appointmentId";
        Query<Prescription> findQuery = session.createQuery(query, Prescription.class);
        findQuery.setParameter("appointmentId",appointmentId);
        return findQuery.getResultList();
    }
}
