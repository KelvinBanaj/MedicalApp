package org.example.dao;

import org.example.entities.Appointment;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


import java.util.List;

public class AppointmentsDao {
//    private final Session session;
//    private Transaction transaction;
//
//    public AppointmentsDao(Session session){
//        this.session = session;
//    }
//
//    public Appointment create (Appointment appointment){
//        try{
//            this.transaction = session.beginTransaction();
//            appointment = session.merge(appointment);
//            transaction.commit();
//            return appointment;
//        } catch (RuntimeException e) {
//            transaction.rollback();
//            throw new RuntimeException(e);
//        }
//    }
//
//    public Appointment findById (Long id){
//        return session.find(Appointment.class,id);
//    }
//
//    public List<Appointment> findAll() {
//            String query = "select * from appointments";
//            Query<Appointment> appointmentsQuery = session.createNativeQuery(query, Appointment.class);
//            return appointmentsQuery.getResultList();
//    }
//
//    public List<Appointment> findByAppointmentsId (Long id){
//        String query = "select * from appointments where appointments_id = :appointments_id";
//        Query<Appointment> appointmentsQuery = session.createNativeQuery(query, Appointment.class);
//        appointmentsQuery.setParameter("appointments_id",id);
//        return appointmentsQuery.getResultList();
//    }
//
//    public void delete (Long id){
//        try{
//            Appointment appointment = this.findById(id);
//            this.transaction = session.beginTransaction();
//            session.remove(appointment);
//            transaction.commit();
//        } catch (RuntimeException e) {
//            transaction.rollback();
//            throw new RuntimeException(e);
//        }
//    }

}
