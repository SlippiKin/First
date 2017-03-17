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
import model.Floorplan;

/**
 *
 * @author INSPIRON 15
 */
@Stateless
public class FloorPlanSessionBean {

    @PersistenceContext(unitName = "Slippi_POSPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    public Floorplan searchFloorPlan(String id, String name) {
           
           Query q = em.createNamedQuery("Floorplan.findByIdnName");
           q.setParameter("id",id); 
           q.setParameter("shelfname",name); 
           Floorplan t = (Floorplan) q.getSingleResult();
           return t;
    }
    
    public void deleteFloorPlan(String id, String name) {
        Floorplan t = searchFloorPlan(id, name);
        em.remove(t);
    }
    
    public List viewAllFloorPlan(String id) {
        Query q = em.createNamedQuery("Floorplan.findById");
        q.setParameter("id", id);        
        List h = q.getResultList();
        return h;
    }
    
    public List viewCustomizeFloorPlan(String id) {
        Query q = em.createNamedQuery("Floorplan.findById2");
        q.setParameter("id", id);        
        List h = q.getResultList();
        return h;
    }
    
    public void insertFloorPlan(Floorplan s, String id) {
        System.out.print("insert function " + s);
        Floorplan FloorPlan = new Floorplan();
        FloorPlan.setId(id);
        FloorPlan.setLevel(s.getLevel());
        FloorPlan.setShelfname(s.getShelfname());
        FloorPlan.setLocation(s.getLocation());
        FloorPlan.setShape(s.getShape());
        em.persist(FloorPlan);
    }
    

}
