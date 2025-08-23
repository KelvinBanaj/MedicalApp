package org.example.repositoires;

import org.example.entities.AppointmentStatus;
import org.example.entities.Appointment;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.time.LocalDateTime;
import java.util.List;

public class AppointmentRepository extends GenericRepositories<Appointment,Long> {
    public final Session session;

    public AppointmentRepository(Session session) {
        super (session, Appointment.class);
        this.session=session;
    }

    public List<Appointment> findByPatientId (Long id) {
        String query = "select a from Appointment a where a.patient.id = :id";
        Query<Appointment> findQuery = session.createQuery(query, Appointment.class);
        findQuery.setParameter("id", id);
        return findQuery.getResultList();

    }
    public List<Appointment>findByDoctorId(Long id){
        String query ="select a from Appointment a where a.doctor.id = :id";
        Query <Appointment>findQuery = session.createQuery(query, Appointment.class);
        findQuery.setParameter("id",id);
        return findQuery.getResultList();
    }

    public List<Appointment>findByStatus(AppointmentStatus appointmentStatus){
        String query = "select a from Appointment a where a.status = :status";
        Query<Appointment> findQuery = session.createQuery(query, Appointment.class);
        findQuery.setParameter("status","%"+appointmentStatus);
        return findQuery.getResultList();
    }

    public List<Appointment>findByTime(LocalDateTime appointmentTime){
        String query ="select a from Appointment a where a.appointmentTime = :appointmentTime";
        Query<Appointment> findQuery = session.createQuery(query, Appointment.class);
        findQuery.setParameter("appointmentTime","%"+appointmentTime);
        return findQuery.getResultList();
    }

    public List<Appointment> findByPurpose(String purpose){
        String query = "select a from Appointment a where a.purpose = :purpose";
        Query<Appointment> findQuery = session.createQuery(query, Appointment.class);
        findQuery.setParameter("purpose","%"+purpose);
        return findQuery.getResultList();
    }

    public Appointment cancelAppointment(Long id) {
        Appointment appointment = this.findById(id);
        appointment.setAppointmentStatus(AppointmentStatus.FSHIRE);
        return this.save(appointment);
    }
}
