/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpSession;
import model.Login;
import model.Sales;
import model.TransDetail;
import utility.datetime;

/**
 *
 * @author blank
 */
@Stateless
public class TransSessionBean {

    @PersistenceContext(unitName = "Slippi_POSPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    public List viewAllTransDetail() {

        Query q = em.createNamedQuery("TransDetail.findAll");
        List h = q.getResultList();

        return h;
    }
    
    public List viewAllTransDetailforuser(String id) {
        Query q = em.createNamedQuery("TransDetail.findById");
        Login loginid = em.getReference(Login.class, id);
        q.setParameter("id", loginid);
        List h = q.getResultList();
        return h;
    }

    public TransDetail searchSales(String id) {
 
        Query q = em.createNamedQuery("Sales.findByNo");
        q.setParameter("Id", id); //**user will giv a value          
        TransDetail t = (TransDetail) q.getSingleResult();
        return t;
    }
        
    public TransDetail searchTransDetail(String id, String tid) {
           Login loginid = em.getReference(Login.class, id);
           Query q = em.createNamedQuery("TransDetail.findByidntid");
           q.setParameter("id",loginid); 
           q.setParameter("transid", tid);
           TransDetail t = (TransDetail) q.getSingleResult();
           return t;
    }
    
    public List searchWeeklyWithDate (String id, String fdate, String sdate) {
           Login loginid = em.getReference(Login.class, id);
           Query q = em.createNamedQuery("TransDetail.findweekly");
           q.setParameter("id",loginid); 
           q.setParameter("first", fdate);
           q.setParameter("second", sdate);
           List h = q.getResultList();
           return h;
    }
    
    public List searchTransWithDate (String id, String date) {
           Login loginid = em.getReference(Login.class, id);
           Query q = em.createNamedQuery("TransDetail.findByidndatentime");
           q.setParameter("id",loginid); 
           q.setParameter("date", date);
           
           List h = q.getResultList();
           return h;
    }
    
    public void insertRecord(TransDetail s, String id) {
        datetime date = new datetime();
        Login loginid = em.getReference(Login.class, id);
        TransDetail t = new TransDetail();
        t.setId(loginid);       
        t.setDate(date.getDate());
        t.setTime(date.getTime());
        t.setTransid(s.getTransid());
        t.setTotal(s.getTotal());
        em.persist(t);

    }

}
