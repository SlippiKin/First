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
import model.Login;
import model.Product;
import model.Supplier;
import utility.productdetail;

/**
 *
 * @author blank
 */
@Stateless
public class SupplierSessionBean {
    @PersistenceContext(unitName = "Slippi_POSPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }
    
    public List viewAllSupplier() {
        Query q = em.createNamedQuery("Supplier.findAll");
        List h = q.getResultList();
        return h;
    }
    
     public Supplier getSupplierInfo(String id, String sname) {
        Query q = em.createNamedQuery("Supplier.findsupplier");
        Login loginid = em.getReference(Login.class, id);
        q.setParameter("id", loginid);
        q.setParameter("sname", sname);
        Supplier t = (Supplier) q.getSingleResult();
        return t;
    }
    
     public void insertRecord(Supplier s,String id) {
        Login loginid = em.getReference(Login.class, id);
        Supplier t = new Supplier();
        t.setAddress(s.getAddress());
        t.setHp(s.getHp());
        t.setId(loginid);
        t.setSellman(s.getSellman());
        t.setSname(s.getSname());
        t.setEmail(s.getEmail());
        em.persist(t);
    }
     
    public void updateSupplier(Supplier s, String id){
        
        Query q = em.createNamedQuery("Supplier.findsupplier");
        Login loginid = em.getReference(Login.class, id);
        q.setParameter("id", loginid);
        q.setParameter("sname", s.getSname());
        
        Supplier t = (Supplier) q.getSingleResult();        
        t.setSellman(s.getSellman());
        t.setAddress(s.getAddress());
        t.setEmail(s.getEmail());
        t.setHp(s.getHp());
        t.setSname(s.getSname());
       
      
        em.merge(t);
    }
  
}
