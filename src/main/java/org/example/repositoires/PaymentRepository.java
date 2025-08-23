package org.example.repositoires;

import org.example.entities.Payments;
import org.hibernate.Session;
import org.hibernate.query.Query;


import java.time.LocalDate;
import java.util.List;

public class PaymentRepository extends GenericRepositories<Payments,Long>{
    private final Session session;

    public PaymentRepository(Session session){
        super (session,Payments.class);
        this.session=session;
    }

    public List<Payments> findByPatientId(Long id){
        String query = "select p from Payments p where p.patient.id = :id";
        Query<Payments> findQuery = session.createQuery(query, Payments.class);
        findQuery.setParameter("id",id);
        return findQuery.getResultList();
    }

    public List<Payments> findByDate(LocalDate paymentDate){
        String query = "select p from Payments p where p.paymentDate = :paymentDate";
        Query<Payments> findQuery = session.createQuery(query, Payments.class);
        return findQuery.getResultList();
    }

    public List<Payments> findByAmount(Double amount){
        String query = "select p from Payments p where p.amount = :amount";
        Query<Payments> findQuery = session.createQuery(query, Payments.class);
        return findQuery.getResultList();
    }

    public List<Payments> findByDescription(String description){
        String query = "select p from Payments where p.description like :description";
        Query<Payments> findQuery = session.createQuery(query, Payments.class);
        return findQuery.getResultList();
    }
}
