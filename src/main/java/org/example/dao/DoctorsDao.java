package org.example.dao;

import org.example.entities.Doctor;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class DoctorsDao extends GenericDao<Doctor,Long> {
//    private final Session session;
//
//    public DoctorsDao (Session session){
//        super(session, Doctor.class);
//        this.session = session;
//    }
//
//    public Doctor save (Doctor doctor){
//        if(this.findById(doctor.getId())!=null){
//            throw new RuntimeException("Doktori me id "+ doctor.getId() + " vjen ne oren : "+ doctor.getStartWorkAt() );
//        }else{
//            return super.save(doctor);
//        }
//    }
//
//    public Doctor findByNid(Long nid){
//        String query = "select d from Doctors d where d.nid = :nid";
//        Query<Doctor> findQuery = session.createQuery(query, Doctor.class);
//        findQuery.setParameter("nid",nid);
//        return findQuery.getSingleResultOrNull();
//    }
//
//    public List <Doctor> findByName (String name){
//        String query = "select d from Doctors d where upper(d.name) like upper(:name)";
//        Query<Doctor> findQuery = session.createQuery(query, Doctor.class);
//        findQuery.setParameter("name","%"+name+"%");
//        return findQuery.getResultList();
//    }
}
