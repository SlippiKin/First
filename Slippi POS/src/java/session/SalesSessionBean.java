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
import model.Sales;
import model.TransDetail;

/**
 *
 * @author blank
 */
@Stateless
public class SalesSessionBean {

    @PersistenceContext(unitName = "Slippi_POSPU")
    private EntityManager em;

    public List viewAllaccount() {

        Query q = em.createNamedQuery("Sales.findAll");
        List h = q.getResultList();

        return h;
    }

    public Sales searchSales(String id) {
 
        Query q = em.createNamedQuery("Sales.findByNo");
        q.setParameter("Id", id); //**user will giv a value          
        Sales t = (Sales) q.getSingleResult();
        return t;
    }
    
    public List viewSalesTransaction(String id, String tid) {
        Login loginid = em.getReference(Login.class, id);
        
        Query q = em.createNamedQuery("Sales.findByidnsalesid");
        q.setParameter("id", loginid);
        q.setParameter("transid", tid);
        List h = q.getResultList();

        return h;
    }
    
    
    
    public void insertRecord(Sales s, String id) {
        Login loginid = em.getReference(Login.class, id);
        Sales t = new Sales();
        t.setBarcode(s.getBarcode());
        t.setId(loginid);
        t.setQuantity(s.getQuantity());
        t.setTransid(s.getTransid());
        em.persist(t);

    }

}
