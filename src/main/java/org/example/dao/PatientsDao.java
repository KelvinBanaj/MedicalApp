package org.example.dao;

import org.example.entities.Patient;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class PatientsDao extends GenericDao<Patient,Long>{
//    private final Session session;
//
//    public PatientsDao(Session session){
//        super(session, Patient.class);
//        this.session = session;
//    }
//
//    public Patient save (Patient patient){
//        if(this.findById(patient.getId()) !=null){
//            throw new RuntimeException("Pacienti me ID : " + patient.getId()+ " ekziston !");
//        }else{
//            return super.save(patient);
//        }
//    }
//
//    public List<Patient> findByName (String name){
//        String query = "select p from Patients p where upper(p.name) like upper(:name)";
//        Query<Patient> findQuery = session.createQuery(query, Patient.class);
//        findQuery.setParameter("name","%"+name+"%");
//        return findQuery.getResultList();
//    }
//
//    public Patient findByNid (String nid){
//        String query = "select p from Patients p where p.nid = :nid";
//        Query<Patient> findQuery = session.createQuery(query, Patient.class);
//        findQuery.setParameter("nid",nid);
//        return findQuery.getSingleResultOrNull();
//    }
}
