package org.example.repositoires;
import org.example.entities.Patient;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.util.List;

public class PatientRepository extends GenericRepositories<Patient,Long> {
    private final Session session;

    public PatientRepository(Session session) {
        super(session, Patient.class);
        this.session = session;
    }

    public List<Patient> findByFirstName(String firstName) {
        String query = "select p from Patient p where p.firstName like :firstName";
        Query<Patient> findQuery = session.createQuery(query, Patient.class);
        findQuery.setParameter("firstName", "%" + firstName);
        return findQuery.getResultList();
    }

    public List<Patient> findByLastName(String lastName) {
        String query = "select p from Patient p where p.lastName like :lastName";
        Query<Patient> findQuery = session.createQuery(query, Patient.class);
        findQuery.setParameter("lastName", "%" + lastName);
        return findQuery.getResultList();
    }

    public List<Patient> findByBirthDate(LocalDate birthDate){
        String query = "select p from Patient p where p.birthDate = :birthDate";
        Query<Patient> findQuery = session.createQuery(query, Patient.class);
        findQuery.setParameter("birthDate",birthDate);
        return findQuery.getResultList();
    }

    public List<Patient> findByNID(String nid){
        String query = "select p from Patient p where p.NID = :NID";
        Query<Patient> findQuery = session.createQuery(query, Patient.class);
        findQuery.setParameter("NID",nid);
        return findQuery.getResultList();
    }

    public List<Patient> findByMedicalHistory(String medicalHistory){
        String query = "select p from Patient p where p.medicalHistory = :medicalHistory";
        Query<Patient> findQuery = session.createQuery(query, Patient.class);
        findQuery.setParameter("medicalHistory","%"+medicalHistory);
        return findQuery.getResultList();
    }

    public List<Patient> findByContactInfo(String contactInfo) {
        String query = "select p from Patient p where p.contactInfo like :contactInfo";
        Query<Patient> findQuery = session.createQuery(query, Patient.class);
        findQuery.setParameter("ContactInfo","%"+ contactInfo);
        return findQuery.getResultList();
    }
}
