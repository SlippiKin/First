/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author blank
 */
@Entity
@Table(name = "product", catalog = "pointofsales", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p"),
    @NamedQuery(name = "Product.findByNo", query = "SELECT p FROM Product p WHERE p.no = :no"),
    @NamedQuery(name = "Product.findByBarcode", query = "SELECT p FROM Product p WHERE p.barcode = :barcode"),
    @NamedQuery(name = "Product.findByidnbarcode", query = "SELECT p FROM Product p WHERE p.id = :id AND p.barcode = :barcode"),
    @NamedQuery(name = "Product.findByProname", query = "SELECT p FROM Product p WHERE p.proname = :proname"),
    @NamedQuery(name = "Product.findByOriginalprice", query = "SELECT p FROM Product p WHERE p.originalprice = :originalprice"),
    @NamedQuery(name = "Product.findBySellingprice", query = "SELECT p FROM Product p WHERE p.sellingprice = :sellingprice"),
    @NamedQuery(name = "Product.findByMinimumquantity", query = "SELECT p FROM Product p WHERE p.minimumquantity = :minimumquantity"),
    @NamedQuery(name = "Product.findByGst", query = "SELECT p FROM Product p WHERE p.gst = :gst"),
    @NamedQuery(name = "Product.findByShelflocation", query = "SELECT p FROM Product p WHERE p.shelflocation = :shelflocation"),
    @NamedQuery(name = "Product.findByCurrentquantity", query = "SELECT p FROM Product p WHERE p.currentquantity = :currentquantity"),
    @NamedQuery(name = "Product.findByCategory", query = "SELECT p FROM Product p WHERE p.category = :category"),
    @NamedQuery(name = "Product.findBySname", query = "SELECT p FROM Product p WHERE p.sname = :sname")})
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "no")
    private Integer no;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "barcode")
    private String barcode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "proname")
    private String proname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "originalprice")
    private String originalprice;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "sellingprice")
    private String sellingprice;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "minimumquantity")
    private String minimumquantity;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "gst")
    private String gst;
    @Size(max = 45)
    @Column(name = "shelflocation")
    private String shelflocation;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "currentquantity")
    private String currentquantity;
    @Lob
    @Column(name = "productimage")
    private byte[] productimage;
    @Size(max = 45)
    @Column(name = "category")
    private String category;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "sname")
    private String sname;
    @JoinColumn(name = "id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Login id;

    public Product() {
    }

    public Product(Integer no) {
        this.no = no;
    }

    public Product(Integer no, String barcode, String proname, String originalprice, String sellingprice, String minimumquantity, String gst, String currentquantity, String sname) {
        this.no = no;
        this.barcode = barcode;
        this.proname = proname;
        this.originalprice = originalprice;
        this.sellingprice = sellingprice;
        this.minimumquantity = minimumquantity;
        this.gst = gst;
        this.currentquantity = currentquantity;
        this.sname = sname;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getProname() {
        return proname;
    }

    public void setProname(String proname) {
        this.proname = proname;
    }

    public String getOriginalprice() {
        return originalprice;
    }

    public void setOriginalprice(String originalprice) {
        this.originalprice = originalprice;
    }

    public String getSellingprice() {
        return sellingprice;
    }

    public void setSellingprice(String sellingprice) {
        this.sellingprice = sellingprice;
    }

    public String getMinimumquantity() {
        return minimumquantity;
    }

    public void setMinimumquantity(String minimumquantity) {
        this.minimumquantity = minimumquantity;
    }

    public String getGst() {
        return gst;
    }

    public void setGst(String gst) {
        this.gst = gst;
    }

    public String getShelflocation() {
        return shelflocation;
    }

    public void setShelflocation(String shelflocation) {
        this.shelflocation = shelflocation;
    }

    public String getCurrentquantity() {
        return currentquantity;
    }

    public void setCurrentquantity(String currentquantity) {
        this.currentquantity = currentquantity;
    }

    public byte[] getProductimage() {
        return productimage;
    }

    public void setProductimage(byte[] productimage) {
        this.productimage = productimage;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Login getId() {
        return id;
    }

    public void setId(Login id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (no != null ? no.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.no == null && other.no != null) || (this.no != null && !this.no.equals(other.no))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Product[ no=" + no + " ]";
    }
    
}
