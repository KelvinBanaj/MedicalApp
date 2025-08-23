package org.example.repositoires;

import org.example.entities.Doctor;
import org.example.entities.DoctorSpecialization;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.print.Doc;
import java.time.LocalTime;
import java.util.List;

public class DoctorRepository extends GenericRepositories<Doctor,Long> {
    private final Session session;

    public DoctorRepository(Session session){
        super(session, Doctor.class);
        this.session=session;
    }

    public List<Doctor> findBySpeciality(DoctorSpecialization doctorSpecialization){
        String query = "select d from Doctor d where s.specialization= :specialization";
        Query<Doctor> findQuery =session.createQuery(query, Doctor.class);
        findQuery.setParameter("specialization",doctorSpecialization);
        return findQuery.list();
    }

    public List<Doctor> findByName(String firstName){
        String query = "select d from Doctor d where d.firstName like :firstName";
        Query<Doctor> findQuery = session.createQuery(query, Doctor.class);
        findQuery.setParameter("firstName","%"+ firstName);
        return findQuery.getResultList();
    }

    public List<Doctor> findByLastName(String lastName){
        String query = "select d from Doctor d where d.lastName like :lastName";
        Query<Doctor> findQuery = session.createQuery(query, Doctor.class);
        findQuery.setParameter("lastName", "%" + lastName);
        return findQuery.getResultList();
    }

    public List<Doctor> findByContactInfo(String contactInfo){
        String query = "select d from Doctor d where d.contactInfo like :contactInfo";
        Query<Doctor> findQuery = session.createQuery(query, Doctor.class);
        findQuery.setParameter("contactInfo", "%" + contactInfo);
        return findQuery.getResultList();
    }

    public List<Doctor> findByStartWork (LocalTime startWorkAt){
        String query = "select d from Doctor d where d.startWorkAt = :startWorkAt";
        Query<Doctor> findQuery = session.createQuery(query, Doctor.class);
        findQuery.setParameter("startWorkAt",startWorkAt);
        return findQuery.getResultList();
    }

    public List<Doctor> findByEndWork (LocalTime endWorkAt){
        String query = "select d from Doctor d where d.endWorkAt= :endWorkAt";
        Query<Doctor> findQuery = session.createQuery(query, Doctor.class);
        findQuery.setParameter("endWorkAt",endWorkAt);
        return findQuery.getResultList();
    }
}
