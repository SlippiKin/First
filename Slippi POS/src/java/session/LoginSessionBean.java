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

/**
 *
 * @author blank
 */
@Stateless
public class LoginSessionBean {

    @PersistenceContext(unitName = "Slippi_POSPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    public List viewAllaccount() {

        Query q = em.createNamedQuery("Login.findAll");
        List h = q.getResultList();

        return h;
    }

    public Login searchAccount(String id) {
//Write some codes here........
        Query q = em.createNamedQuery("Login.findById");
        q.setParameter("id", id); //**user will giv a value          
        Login t = (Login) q.getSingleResult();
        return t;
    }

    public void insertRecord(Login s) {
//Write some codes here........

        Login t = new Login();
        t.setBusname(s.getBusname());
        t.setDob(s.getDob());
        t.setEmail(s.getEmail());
        t.setHp(s.getHp());
        t.setId(s.getId());
        t.setName(s.getName());
        t.setPassword(s.getPassword());
        t.setSuccessful(s.getSuccessful());
        t.setUnsuccessful(s.getUnsuccessful());
        em.persist(t);

    }
    public void updateLogin(Login s) {
         
        Query q = em.createNamedQuery("Login.findById");       
        q.setParameter("id", s.getId());               
        Login t = (Login) q.getSingleResult();        
        t.setBusname(s.getBusname());
        t.setDob(s.getDob());
        t.setEmail(s.getEmail());
        t.setHp(t.getHp());
        t.setName(s.getName());
        t.setPassword(s.getPassword());
        t.setUnsuccessful(s.getUnsuccessful());
        t.setSuccessful(s.getSuccessful());
      
        em.merge(t);
        
    }
}
