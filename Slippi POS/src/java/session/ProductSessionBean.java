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
import utility.productdetail;

/**
 *
 * @author blank
 */
@Stateless
public class ProductSessionBean {
    @PersistenceContext(unitName = "Slippi_POSPU")
    private EntityManager em;
    
    public void persist(Object object) {
        em.persist(object);
    }
    public List viewAllProduct() {

        Query q = em.createNamedQuery("Product.findAll");
        List h = q.getResultList();

        return h;
    }
    
    public Product searchProduct(String id) {
//Write some codes here........
        Query q = em.createNamedQuery("Product.findByBarcode");
        q.setParameter("barcode", id);          
        Product t = (Product) q.getSingleResult();
        return t;
    }
    
    
    public Product searchProductbyIDnBarcode(String id, String barcode) {
        Login loginid = em.getReference(Login.class, id);
        Query q = em.createNamedQuery("Product.findByidnbarcode");
        q.setParameter("id", loginid); 
        q.setParameter("barcode", barcode);
        Product t = (Product) q.getSingleResult();
        System.out.print("entered" + t);
        return t;
    }

    public void insertRecord(productdetail s) {
 
        Login loginid = em.getReference(Login.class, s.getId());
        Product t = new Product();
        
        t.setBarcode(s.getBarcode());
        t.setCategory(s.getCategory());
        t.setCurrentquantity(s.getCurrentquantity());
        t.setGst(s.getGst());
        t.setMinimumquantity(s.getMinimumquantity());
        t.setOriginalprice(s.getOriginalprice());
       // t.setProductimage(productimage);
        t.setProname(s.getProname());
        t.setSellingprice(s.getSellingprice());
        t.setShelflocation(s.getShelflocation());
        t.setSname(s.getSname());
        t.setId(loginid);
        
        em.persist(t);

    }
    
    public void updateProduct(productdetail s) {
        Login loginid = em.getReference(Login.class, s.getId());
        Query q = em.createNamedQuery("Product.findByidnbarcode");
        q.setParameter("barcode", s.getBarcode());
        q.setParameter("id", loginid);               
        Product t = (Product) q.getSingleResult();        
        t.setCategory(s.getCategory());
        t.setCurrentquantity(s.getCurrentquantity());
        t.setGst(s.getGst());
        t.setMinimumquantity(s.getMinimumquantity());  
        t.setOriginalprice(s.getOriginalprice());
        //t.setProductimage(productimage);
        t.setProname(s.getProname());
        t.setSellingprice(s.getSellingprice());
        t.setShelflocation(s.getShelflocation());
        t.setSname(s.getSname());
        t.setId(loginid);
        em.merge(t);
    }
       
}
