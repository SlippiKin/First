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
import model.Customer;
import model.Customerdetail;
import model.Login;
import model.TransDetail;

/**
 *
 * @author INSPIRON 15
 */
@Stateless
public class CustomerSessionBean {

    @PersistenceContext(unitName = "Slippi_POSPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }
    
    public Customer searchCustomer(String id, String custno) {
           
           Query q = em.createNamedQuery("Customer.findByidncustno");
           q.setParameter("id",id); 
           q.setParameter("custno", custno);
           Customer t = (Customer) q.getSingleResult();
           return t;
    }
    
    public Customer searchCustomerByName(String id, String custname) {
           
           Query q = em.createNamedQuery("Customer.findByidncustname");
           q.setParameter("id",id); 
           q.setParameter("custname", custname);
           Customer t = (Customer) q.getSingleResult();
           return t;
    }
    
    public Customerdetail searchCustomerDetail(String id, String custno, String tid) {
           System.out.print("in name and custno = " + id + " " + custno);
           Query q = em.createNamedQuery("Customerdetail.findByidncustnontid");
           q.setParameter("id",id); 
           q.setParameter("tid", tid);
           q.setParameter("custno", custno);
           Customerdetail t = (Customerdetail) q.getSingleResult();
           return t;
    }
    
    public void deleteCustomer(String id, String custno) {
        Customer t = searchCustomer(id, custno);
        em.remove(t);
    }
    
    public void deleteCustomerDetail(String id, String custno, String tid) {
        Customerdetail t = searchCustomerDetail(id, custno, tid);
        em.remove(t);
    }
    
    public List viewAllCustomerDetailRecord(String id) {
        Query q = em.createNamedQuery("Customerdetail.findById");
        q.setParameter("id", id);        
        List h = q.getResultList();
        return h;
    }
    
    public List viewAllCustomerDetail(String id, String custno) {
        Query q = em.createNamedQuery("Customerdetail.findByCustnonId");
        q.setParameter("custno", custno);
        q.setParameter("id", id);        
        List h = q.getResultList();
        return h;
    }
    
    public List viewAllCustomer(String id) {
        Query q = em.createNamedQuery("Customer.findById");
        q.setParameter("id", id);        
        List h = q.getResultList();
        return h;
    }
    
    public void insertCustomerRecord(Customer s) {
        Customer customer = new Customer();
        customer.setCustname(s.getCustname());
        customer.setCustno(s.getCustno());
        customer.setEmail(s.getEmail());
        customer.setId(s.getId());
        customer.setPh(s.getPh());
        customer.setTotal(s.getTotal());       
        em.persist(customer);
    }
    
    public void insertCustomerDetailRecord(Customerdetail s) {
        Customerdetail customerdetail = new Customerdetail();
        customerdetail.setCustno(s.getCustno());
        customerdetail.setDate(s.getDate());
        customerdetail.setDetailno(s.getDetailno());
        customerdetail.setId(s.getId());
        customerdetail.setRemain(s.getRemain());
        customerdetail.setTime(s.getTime());
        customerdetail.setTransid(s.getTransid());
        em.persist(customerdetail);
    }
    
    public void updateCustomerDetail(Customerdetail customerdetail, String id, String custno){        
        Query q = em.createNamedQuery("Customerdetail.findByCustnonId");
        q.setParameter("id", id);
        q.setParameter("custno", custno);
        em.merge(customerdetail);
    }
    
    public void updateCustomer(Customer customer, String id, String custno){        
        Query q = em.createNamedQuery("Customer.findByidncustno");
        q.setParameter("id", id);
        q.setParameter("custno", custno);
        em.merge(customer);
    }

  
}
