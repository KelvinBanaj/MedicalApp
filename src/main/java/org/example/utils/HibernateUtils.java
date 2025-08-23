package org.example.utils;

import org.example.entities.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory(){
        if(sessionFactory == null){
            Configuration configuration = new Configuration();
            configuration.addAnnotatedClass(Appointment.class);
            configuration.addAnnotatedClass(Doctor.class);
            configuration.addAnnotatedClass(Patient.class);
            configuration.addAnnotatedClass(Payments.class);
            configuration.addAnnotatedClass(Prescription.class);
            sessionFactory = configuration.buildSessionFactory();
        }
        return sessionFactory;
    }
}
