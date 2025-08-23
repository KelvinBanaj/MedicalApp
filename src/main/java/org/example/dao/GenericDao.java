package org.example.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public abstract class GenericDao <E,ID> {
//    private final Session session;
//    private final Class<E> clazz;
//    private Transaction transaction;
//
//    protected GenericDao (Session session, Class<E> clazz){
//        this.session = session;
//        this.clazz = clazz;
//    }
//
//    public E save (E entity){
//        try{
//            this.transaction = session.beginTransaction();
//            E savedEntity = session.merge(entity);
//            transaction.commit();
//            return savedEntity;
//        } catch (Exception e) {
//            transaction.rollback();
//            throw new RuntimeException(e);
//        }
//    }
//
//    public E findById(ID id){
//        return session.find(clazz,id);
//    }
//
//    public void delete (ID id){
//        try{
//            this.transaction = session.beginTransaction();
//            E entity = this.findById(id);
//            session.remove(entity);
//            transaction.commit();
//        } catch (RuntimeException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public List<E> findAll(){
//        String query = "select record from".concat(clazz.getSimpleName()).concat("record");
//        Query<E> findAllQuery = session.createQuery(query,clazz);
//        return findAllQuery.getResultList();
//    }
}
